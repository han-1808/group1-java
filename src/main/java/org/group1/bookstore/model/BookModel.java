package org.group1.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private Integer id;
    private String code;
    private String name;
    private Long import_price;
    private Short status;
    private String category;
    private String publisher;
    private String author;
    private Short hot_new;
    private Short out_of_stock;
}
