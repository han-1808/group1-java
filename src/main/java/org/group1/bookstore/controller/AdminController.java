package org.group1.bookstore.controller;

import javafx.scene.layout.Region;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.group1.bookstore.view.AdminView;

@Getter
@Setter
@AllArgsConstructor
public class AdminController {
    private AdminView adminView;
    private Stage stage;

    public AdminController(Stage stage) {
        this.stage = stage;
        this.adminView = new AdminView();
    }

    public Region getView() {
        return adminView.getView(stage);
    }
}
