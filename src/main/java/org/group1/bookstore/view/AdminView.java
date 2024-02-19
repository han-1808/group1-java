package org.group1.bookstore.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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

        grid.add(tabPane, 0, 1);

        Button button = new Button();
        button.setText("Logout");
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

        Pane pane = new Pane();

        TextField searchTxt = new TextField();
        searchTxt.setPromptText("Nhập Tên đăng nhập hoặc Tên người dùng");
        pane.getChildren().add(searchTxt);

        TableView<UserModel> userTbl = getTableAccount(searchTxt);
        userTbl.relocate(0, 30);

        pane.getChildren().add(userTbl);

        tabViewAccount.setContent(pane);

        return tabViewAccount;
    }

    private TableView<UserModel> getTableAccount(TextField searchTxt) {
        TableView<UserModel> userTbl = new TableView<>();

        TableColumn<UserModel, String> userNameCol = new TableColumn<>("Tên đăng nhập");
        TableColumn<UserModel, String> fullNameCol = new TableColumn<>("Tên người dùng");
        TableColumn<UserModel, String> statusCol = new TableColumn<>("Trạng thái");
        TableColumn<UserModel, String> roleCol = new TableColumn<>("Vai trò");

        userNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getUsername()));
        fullNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getFullName()));
        statusCol.setCellValueFactory(user -> new SimpleStringProperty(Status.getStatusContent(user.getValue().getStatus())));
        roleCol.setCellValueFactory(user -> new SimpleStringProperty(Role.getRoleContent(user.getValue().getRole())));

        userTbl.getColumns().setAll(userNameCol, fullNameCol, statusCol, roleCol);

        List<UserModel> users = userDao.findAll();
        FilteredList<UserModel> filteredData = new FilteredList<>(FXCollections.observableArrayList(users), p -> true);

        searchTxt.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(user -> {
            // If filter text is empty, display all users.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare first name and last name of every user with filter text.
            String lowerCaseFilter = newValue.toLowerCase().trim();

            if (user.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches user name.
            }
            return user.getFullName().toLowerCase().contains(lowerCaseFilter); // Filter matches full name.
        }));

        SortedList<UserModel> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(userTbl.comparatorProperty());

        userTbl.setItems(sortedData);
        return userTbl;
    }
}
