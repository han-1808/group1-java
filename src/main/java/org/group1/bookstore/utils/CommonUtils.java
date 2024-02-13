package org.group1.bookstore.utils;

import org.group1.bookstore.constant.CommonConstant;

import java.util.Objects;

public class CommonUtils {

    public static boolean isAdmin(Short role) {
        return Objects.equals(role, CommonConstant.ADMIN);
    }

    public static boolean isEmployee(Short role) {
        return Objects.equals(role, CommonConstant.EMPLOYEE);
    }
}
