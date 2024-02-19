package org.group1.bookstore.dto.enumtype;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum OutOfStock {

    STOCK((short) 0, "Còn hàng"),
    OUT_OF_STOCK((short) 1, "Hết hàng");

    private final Short value;
    private final String content;

    OutOfStock(Short value, String content) {
        this.value = value;
        this.content = content;
    }

    public static String getOutOfStockContent(Short value) {
        for (OutOfStock status : OutOfStock.values()) {
            if (Objects.equals(status.getValue(), value)) {
                return status.getContent();
            }
        }
        return "";
    }
}
