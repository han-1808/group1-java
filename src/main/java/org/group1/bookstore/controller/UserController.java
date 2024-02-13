package org.group1.bookstore.controller;

import javafx.scene.layout.Region;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.group1.bookstore.view.UserView;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

    private UserView userView;
    private Stage stage;

    public UserController(Stage stage) {
        this.stage = stage;
        this.userView = new UserView();
    }

    public Region getView() {
        return userView.getView(stage);
    }
}
