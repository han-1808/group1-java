package org.group1.bookstore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.group1.bookstore.controller.UserController;

public class BookStoreApplication extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new UserController(stage).getView(), 300, 275);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}