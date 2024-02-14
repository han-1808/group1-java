package org.group1.bookstore.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import org.group1.bookstore.dao.UserDao;
import org.group1.bookstore.dao.impl.UserDaoImpl;
import org.group1.bookstore.dto.enumtype.Role;
import org.group1.bookstore.dto.enumtype.Status;
import org.group1.bookstore.model.UserModel;

import java.util.List;

@Getter
@Setter
public class AdminView {

    private UserDao userDao = new UserDaoImpl();

    public Region getView(Stage stage) {
        GridPane grid = new GridPane();

        Text sceneTitle = new Text("Admin Page");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(getTabViewAccount());

        /*Tab tabViewBook = new Tab("View Book", new Label("View a list of books"));
        tabViewBook.setClosable(false);
        tabPane.getTabs().add(tabViewBook);*/

        grid.add(tabPane, 0, 1);

        Button button = new Button();
        button.setText("Back");
        button.setOnAction(event -> {
            stage.setScene(new Scene(new UserController(stage).getView(), 300, 275));
            stage.show();
        });
        grid.add(button, 1, 10);

        return new VBox(grid);
    }

    private Tab getTabViewAccount() {
        Tab tabViewAccount = new Tab("View Account", new Label("View a list of user accounts"));
        tabViewAccount.setClosable(false);
        tabViewAccount.setContent(getTableAccount());

        return tabViewAccount;
    }

    private TableView<UserModel> getTableAccount() {
        TableView<UserModel> userTbl = new TableView<>();

        TableColumn<UserModel, String> userNameCol = new TableColumn<>("Tên đăng nhập");
        TableColumn<UserModel, String> fullNameCol = new TableColumn<>("Tên người dùng");
        TableColumn<UserModel, String> statusCol = new TableColumn<>("Trạng thái");
        TableColumn<UserModel, String> roleCol = new TableColumn<>("Vai trò");

        userNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getUsername()));
        fullNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getFullName()));
        statusCol.setCellValueFactory(user -> new SimpleStringProperty(Status.getStatusContent(user.getValue().getStatus())));
        roleCol.setCellValueFactory(user -> new SimpleStringProperty(Role.getRoleContent(user.getValue().getRole())));

        List<UserModel> users = userDao.findAll();
        userTbl.setItems(FXCollections.observableArrayList(users));
        userTbl.getColumns().setAll(userNameCol, fullNameCol, statusCol, roleCol);

        return userTbl;
    }
}
