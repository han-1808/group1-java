package org.group1.bookstore.dao.impl;

import org.group1.bookstore.constant.CommonConstant;
import org.group1.bookstore.dao.UserDao;
import org.group1.bookstore.mapper.UserMapper;
import org.group1.bookstore.model.UserModel;

import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<UserModel> implements UserDao {

    @Override
    public UserModel findById(Integer id) {
        String sql = "SELECT * FROM user u WHERE u.id = ? AND u.status = " + CommonConstant.ACTIVE;
        List<UserModel> users = query(sql, new UserMapper(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserModel findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM user u WHERE u.username = ? AND u.password = ?";
        List<UserModel> users = query(sql, new UserMapper(),username,password);
        return users.isEmpty() ? null : users.get(0);
    }
}
