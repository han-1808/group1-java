package org.group1.bookstore.dao;

import org.group1.bookstore.model.UserModel;

import java.util.List;

public interface UserDao extends GenericDao<UserModel> {

    UserModel findById(Integer id);
    UserModel findByUsernameAndPassword(String username, String password);

    List<UserModel> findAll();
}
