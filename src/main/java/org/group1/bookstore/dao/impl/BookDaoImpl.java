package org.group1.bookstore.dao.impl;

import org.group1.bookstore.dao.BookDao;
import org.group1.bookstore.dao.UserDao;
import org.group1.bookstore.dto.enumtype.Status;
import org.group1.bookstore.mapper.BookMapper;
import org.group1.bookstore.mapper.UserMapper;
import org.group1.bookstore.model.BookModel;
import org.group1.bookstore.model.UserModel;

import java.util.List;

public class BookDaoImpl extends GenericDaoImpl<BookModel> implements BookDao {

    @Override
    public BookModel findById(Integer id) {
        String sql = "SELECT b.id,\n" +
                "       code,\n" +
                "       b.name,\n" +
                "       import_price,\n" +
                "       b.status,\n" +
                "       c.name as category_id,\n" +
                "       p.name as publisher_id,\n" +
                "       a.name as author_id,\n" +
                "       hot_new,\n" +
                "       out_of_stock\n" +
                "FROM book b\n" +
                "         LEFT JOIN category c ON c.id = b.category_id\n" +
                "         LEFT JOIN publisher p ON p.id = b.publisher_id\n" +
                "         LEFT JOIN author a ON a.id = b.author_id\n" +
                "WHERE b.id = ? AND b.status = " + Status.ACTIVE.getValue();
        List<BookModel> books = query(sql, new BookMapper(), id);
        return books.isEmpty() ? null : books.get(0);
    }

    @Override
    public BookModel findByName(String name) {
        String sql = "SELECT b.id,\n" +
                "       code,\n" +
                "       b.name,\n" +
                "       import_price,\n" +
                "       b.status,\n" +
                "       c.name as category_id,\n" +
                "       p.name as publisher_id,\n" +
                "       a.name as author_id,\n" +
                "       hot_new,\n" +
                "       out_of_stock\n" +
                "FROM book b\n" +
                "         LEFT JOIN category c ON c.id = b.category_id\n" +
                "         LEFT JOIN publisher p ON p.id = b.publisher_id\n" +
                "         LEFT JOIN author a ON a.id = b.author_id\n" +
                "WHERE b.name = ?";
        List<BookModel> users = query(sql, new BookMapper(),name);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<BookModel> findAll() {
        String sql = "SELECT b.id,\n" +
                "       code,\n" +
                "       b.name,\n" +
                "       import_price,\n" +
                "       b.status,\n" +
                "       c.name as category_id,\n" +
                "       p.name as publisher_id,\n" +
                "       a.name as author_id,\n" +
                "       hot_new,\n" +
                "       out_of_stock\n" +
                "FROM book b\n" +
                "         LEFT JOIN category c ON c.id = b.category_id\n" +
                "         LEFT JOIN publisher p ON p.id = b.publisher_id\n" +
                "         LEFT JOIN author a ON a.id = b.author_id";
        return query(sql, new BookMapper());
    }
}
