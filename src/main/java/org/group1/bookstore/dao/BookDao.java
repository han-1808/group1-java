package org.group1.bookstore.dao;

import org.group1.bookstore.model.BookModel;
import org.group1.bookstore.model.UserModel;

import java.util.List;

public interface BookDao extends GenericDao<BookModel> {

    BookModel findById(Integer id);
    BookModel findByName(String name);

    List<BookModel> findAll();
}
