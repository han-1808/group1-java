package org.group1.bookstore.dto.enumtype;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum Status {

    INACTIVE((short) 0, "Không hoạt động"),
    ACTIVE((short) 1, "Đang hoạt động");

    private final Short value;
    private final String content;

    Status(Short value, String content) {
        this.value = value;
        this.content = content;
    }

    public static String getStatusContent(Short value) {
        for (Status status : Status.values()) {
            if (Objects.equals(status.getValue(), value)) {
                return status.getContent();
            }
        }
        return "";
    }
}
