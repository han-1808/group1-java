package org.group1.bookstore.utils;

import org.group1.bookstore.dto.enumtype.Role;

import java.util.Objects;

public class CommonUtils {

    public static boolean isAdmin(Short role) {
        return Objects.equals(role, Role.ADMIN.getValue());
    }

    public static boolean isEmployee(Short role) {
        return Objects.equals(role, Role.EMPLOYEE.getValue());
    }
}
