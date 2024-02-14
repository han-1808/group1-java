# create database book_store;
use book_store;
drop table if exists user;

create table user
(
    id        int auto_increment primary key not null,
    username  varchar(30)                    not null,
    full_name varchar(200)                   not null,
    status    tinyint(1)                     not null,
    password  varchar(255)                   not null,
    role      tinyint(1)                     not null
);

insert into book_store.user(username, full_name, status, password, role)
values ('cuongpq', 'Cuong', 1, 1234, 1),
       ('yenpn', 'Yen', 1, 1234, 2),
       ('mypt', 'My', 0, 1234, 2);
select *
from user;

drop table if exists category;

create table category
(
    id     int auto_increment primary key not null,
    name   varchar(50)                    not null,
    status tinyint(1)                     not null default 1
);

insert into category(name)
values ('Văn học'),
       ('Kinh tế'),
       ('Tâm lý'),
       ('Giáo khoa'),
       ('Chính trị'),
       ('Sách ngoại ngữ');

select *
from category;


drop table if exists publisher;

create table publisher
(
    id     int auto_increment primary key not null,
    name   varchar(50)                    not null,
    status tinyint(1)                     not null default 1
);

insert into publisher(name)
values ('Nhà xuất bản Hội Nhà văn Việt Nam'),
       ('Nhà xuất bản Lao Động'),
       ('Nhà xuất bản Chính trị quốc gia sự thật'),
       ('Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh'),
       ('Nhà xuất bản Trẻ'),
       ('Nhà xuất bản Kim Đồng');

select *
from publisher;

drop table if exists author;

create table author
(
    id     int auto_increment primary key not null,
    name   varchar(50)                    not null,
    status tinyint(1)                     not null default 1
);


insert into author(name)
values ('Tô Hoài'),
       ('Nguyễn Nhật Ánh'),
       ('Nguyễn Ngọc Thuần'),
       ('Nhiều tác giả'),
       ('Dan Ariely'),
       ('Peter Calvocoressi');

select *
from author;

drop table if exists book;

create table book
(
    id           int auto_increment primary key not null,
    code         varchar(10)                    not null unique,
    name         varchar(255)                   not null,
    import_price decimal(12, 0)                 not null,
    status       tinyint(1)                     not null,
    category_id  int(11)                        not null,
    foreign key (category_id) references category (id),
    publisher_id int(11)                        not null,
    foreign key (publisher_id) references publisher (id),
    author_id    int(11)                        not null,
    foreign key (author_id) references author (id),
    hot_new      tinyint(1),
    out_of_stock bool default false
);

insert into book (code, name, import_price, status, category_id, publisher_id, author_id, hot_new, out_of_stock)
values ('VH_1000001', 'Chuyến phiêu lưu của Dế Mèn', 120000, 1, 1, 1, 1, 1, FALSE),
       ('VH_1000002', 'Cho tôi xin một vé đi tuổi thơ', 80000, 1, 1, 3, 2, NULL, FALSE),
       ('VH_1000003', 'Vừa nhắm mắt vừa mở cửa sổ', 110000, 1, 1, 2, 3, 2, FALSE),
       ('KT_1000001', 'Kinh tế Việt Nam 30 năm đổi mới và phát triển', 210000, 1, 2, 4, 4, 2, FALSE),
       ('TL_1000001', 'Phi lý trí', 70000, 1, 3, 3, 5, 1, FALSE),
       ('CT_1000001', 'Chính Trị Thế Giới Sau Năm 1945', 70000, 1, 5, 6, 6, NULL, FALSE);

select *
from book;

drop table if exists inventory;

create table inventory
(
    id       int auto_increment primary key not null,
    book_id  int                            not null,
    foreign key (book_id) references book (id),
    quantity int                            not null
);


insert into inventory(book_id, quantity)
values (2, 23),
       (3, 7),
       (1, 45),
       (4, 10),
       (5, 8),
       (6, 10);

select *
from inventory;

drop table if exists customer;

create table customer
(
    id        int auto_increment primary key not null,
    full_name varchar(50)                    not null,
    phone     varchar(10)                    not null
);

insert into customer(full_name, phone)
values ('Phong', '0123456789'),
       ('Cường', '0123456989'),
       ('Như', '0123489789');

select *
from customer;

drop table if exists payment;
# delete from payment;
create table payment
(
    id               int auto_increment primary key not null,
    customer_id      int,
    foreign key (customer_id) references customer (id),
    payment_date     datetime       default CURRENT_TIMESTAMP,
    status           tinyint(1)                     not null,
    user_id          int                            not null,
    foreign key (user_id) references user (id),
    total_sale_price DECIMAL(12, 0) default 0,
    check ( total_sale_price >= 0 )
);

drop table if exists re_book_payment;

create table re_book_payment
(
    id             int auto_increment primary key not null,
    book_id        int                            not null,
    foreign key (book_id) references book (id),
    payment_id     int,
    foreign key (payment_id) references payment (id),
    quantity_order int                            not null,
    CHECK (quantity_order >= 0)
);

insert into payment(customer_id, status, user_id)
values (2, 1, 3),
       (3, 1, 3),
       (1, 2, 2);

insert into re_book_payment(book_id, payment_id, quantity_order)
values (2, 1, 2),
       (1, 1, 1),
       (3, 1, 3),
       (5, 2, 4),
       (6, 2, 1),
       (3, 3, 3);

DROP TRIGGER IF EXISTS book_store.tg_bi_payment_contains_book;
create trigger tg_bi_payment_contains_book
    before insert on payment
    for each row
    set NEW.total_sale_price = (SELECT sum(quantity_order *
                                           (select book.import_price
                                            from book
                                            where book.id = re_book_payment.book_id
                                            limit 1))
                                FROM re_book_payment
                                WHERE payment_id = NEW.id
                                GROUP BY NEW.id
                                LIMIT 1);

# select * from payment
# delete from payment;

ALTER TABLE payment
    ADD COLUMN discount_percent     decimal(12, 0)
                                    GENERATED ALWAYS AS (IF(customer_id is not null, 5, 0)) STORED,
    ADD COLUMN total_payment_amount decimal(12, 0)
                                    GENERATED ALWAYS AS (total_sale_price * (1.0 - discount_percent / 100)) STORED
;


/*select *
from re_book_payment;
select *
from payment;*/
update payment set total_sale_price =(SELECT sum(quantity_order *
                                                 (select book.import_price
                                                  from book
                                                  where book.id = re_book_payment.book_id
                                                  limit 1))
                                      FROM re_book_payment
                                      WHERE payment_id = payment.id
                                      GROUP BY payment.id
                                      LIMIT 1)
