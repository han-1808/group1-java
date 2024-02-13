package org.group1.bookstore.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.group1.bookstore.dao.impl.UserDaoImpl;
import org.group1.bookstore.model.UserModel;
import org.group1.bookstore.utils.StyleUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserView {

    private UserDaoImpl userDao = new UserDaoImpl();

    private UserModel userModel = new UserModel();

    public Region getView(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label usernameLbl = new Label("User Name:");
        grid.add(usernameLbl, 0, 1);

        TextField usernameTxt = new TextField();
        grid.add(usernameTxt, 1, 1);

        Label passwordLbl = new Label("Password:");
        grid.add(passwordLbl, 0, 2);

        PasswordField passwordTxt = new PasswordField();
        grid.add(passwordTxt, 1, 2);

        VBox vBox = new VBox(grid);
        vBox.getStylesheets().add(StyleUtils.getStyle(UserView.class, "/css/login.css"));

        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.getStyleClass().add("login-btn");
        loginBtn.setOnAction(loginEvt(stage));
        grid.add(loginBtn, 1, 3);

        return vBox;
    }

    private EventHandler<ActionEvent> loginEvt(Stage stage) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        };
    }

    ;
}
