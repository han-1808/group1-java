package org.group1.bookstore.mapper;

import org.group1.bookstore.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs) {
        try {
            UserModel userModel = new UserModel();
            userModel.setId(rs.getInt("id"));
            userModel.setUsername(rs.getString("username"));
            userModel.setFullName(rs.getString("full_name"));
            userModel.setPassword(rs.getString("password"));
            userModel.setRole(rs.getShort("role"));
            userModel.setStatus(rs.getShort("status"));

            return userModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
