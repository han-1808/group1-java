package org.group1.bookstore.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.group1.bookstore.controller.UserController;

@Getter
@Setter
public class AdminView {
    public Region getView(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Admin Page");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Button button = new Button();
        button.setText("Back");
        button.setOnAction(event -> {
            stage.setScene(new Scene(new UserController(stage).getView(), 300, 275));
            stage.show();
        });
        grid.add(button, 1, 1);

        return new VBox(grid);
    }
}
