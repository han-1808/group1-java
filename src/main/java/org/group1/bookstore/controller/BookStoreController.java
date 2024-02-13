package org.group1.bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookStoreController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}