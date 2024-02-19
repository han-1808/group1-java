package org.group1.bookstore.dto.enumtype;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum HotNew {

    HOT((short) 1, "Hot"),
    NEW((short) 2, "New");

    private final Short value;
    private final String content;

    HotNew(Short value, String content) {
        this.value = value;
        this.content = content;
    }

    public static String getHotNewContent(Short value) {
        for (HotNew status : HotNew.values()) {
            if (Objects.equals(status.getValue(), value)) {
                return status.getContent();
            }
        }
        return "";
    }
}
