package org.group1.bookstore.dao;

import org.group1.bookstore.model.UserModel;

public interface UserDao extends GenericDao<UserModel> {

    UserModel findById(Integer id);
    UserModel findByUsernameAndPassword(String username, String password);
}
