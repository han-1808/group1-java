package org.group1.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Integer id;
    private String username;
    private String fullName;
    private Short status;
    private String password;
    private Short role;
}
