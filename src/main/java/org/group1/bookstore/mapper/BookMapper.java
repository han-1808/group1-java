package org.group1.bookstore.mapper;

import org.group1.bookstore.model.BookModel;
import org.group1.bookstore.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookModel> {

    @Override
    public BookModel mapRow(ResultSet rs) {
        try {
            BookModel bookModel = new BookModel();
            bookModel.setId(rs.getInt("id"));
            bookModel.setCode(rs.getString("code"));
            bookModel.setName(rs.getString("name"));
            bookModel.setImport_price(rs.getLong("import_price"));
            bookModel.setStatus(rs.getShort("status"));
            bookModel.setCategory(rs.getString("category_id"));
            bookModel.setPublisher(rs.getString("publisher_id"));
            bookModel.setAuthor(rs.getString("author_id"));
            bookModel.setHot_new(rs.getShort("hot_new"));
            bookModel.setOut_of_stock(rs.getShort("out_of_stock"));

            return bookModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
