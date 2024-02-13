package org.group1.bookstore.utils;

import java.net.URL;

public class StyleUtils {

    public static <T> String getStyle(Class<T> clazz, String filePath) {
        URL url = clazz.getResource(filePath);
        return url == null ? "" : url.toExternalForm();
    }
}
