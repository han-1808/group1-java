package org.group1.bookstore.dto.enumtype;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum Role {

    ADMIN((short) 1, "Admin"),
    EMPLOYEE((short) 2, "Nhân viên");

    private final Short value;
    private final String content;

    Role(Short value, String content) {
        this.value = value;
        this.content = content;
    }

    public static String getRoleContent(Short value) {
        for (Role status : Role.values()) {
            if (Objects.equals(status.getValue(), value)) {
                return status.getContent();
            }
        }
        return "";
    }
}
