package org.group1.bookstore.dao;

import org.group1.bookstore.mapper.RowMapper;

import java.util.List;

public interface GenericDao<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

    int insert(String sql, Object... parameters);

    int count(String sql, Object... parameters);
}
