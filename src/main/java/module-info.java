module org.group1.bookstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires static lombok;

    opens org.group1.bookstore to javafx.fxml;
    exports org.group1.bookstore;
    exports org.group1.bookstore.controller;
    opens org.group1.bookstore.controller to javafx.fxml;
}