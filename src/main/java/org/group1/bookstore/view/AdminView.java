package org.group1.bookstore.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
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
        tabPane.getTabs().add(getTabViewAccount(stage));

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

    private Tab getTabViewAccount(Stage stage) {
        Tab tabViewAccount = new Tab("View Account", new Label("View a list of user accounts"));
        tabViewAccount.setClosable(false);

        Pane pane = new Pane();

        TextField searchTxt = new TextField();
        searchTxt.setPromptText("Nhập Tên đăng nhập hoặc Tên người dùng");
        pane.getChildren().add(searchTxt);

        TableView<UserModel> userTbl = getTableAccount(searchTxt, stage);
        userTbl.relocate(0, 30);

        pane.getChildren().add(userTbl);

        tabViewAccount.setContent(pane);

        return tabViewAccount;
    }

    private TableView<UserModel> getTableAccount(TextField searchTxt, Stage stage) {
        TableView<UserModel> userTbl = new TableView<>();

        TableColumn<UserModel, String> userNameCol = new TableColumn<>("Tên đăng nhập");
        TableColumn<UserModel, String> fullNameCol = new TableColumn<>("Tên người dùng");
        TableColumn<UserModel, String> statusCol = new TableColumn<>("Trạng thái");
        TableColumn<UserModel, String> roleCol = new TableColumn<>("Vai trò");
        TableColumn<UserModel, Void> actionBtn = new TableColumn<>("Thao tác");

        userNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getUsername()));
        fullNameCol.setCellValueFactory(user -> new SimpleStringProperty(user.getValue().getFullName()));
        statusCol.setCellValueFactory(user -> new SimpleStringProperty(Status.getStatusContent(user.getValue().getStatus())));
        roleCol.setCellValueFactory(user -> new SimpleStringProperty(Role.getRoleContent(user.getValue().getRole())));
        Callback<TableColumn<UserModel, Void>, TableCell<UserModel, Void>> cellFactory = new Callback<TableColumn<UserModel, Void>, TableCell<UserModel, Void>>() {
            @Override
            public TableCell<UserModel, Void> call(final TableColumn<UserModel, Void> param) {
                final TableCell<UserModel, Void> cell = new TableCell<UserModel, Void>() {

                    private final Button btn = new Button("Update information");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            UserModel data = getTableView().getItems().get(getIndex());
                            showAddPersonDialog(stage, userTbl, 1);
                            userTbl.getSelectionModel().select(getTableRow().getIndex());
//                            System.out.println("selectedData: " + data);
                        });
                    }

                    private final Button btnChangePass = new Button("Change Password");

                    {
                        btnChangePass.setOnAction((ActionEvent event) -> {
                            UserModel data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
//                            setGraphic(btnChangePass);
                        }
                    }
                };
                return cell;
            }
        };

        actionBtn.setCellFactory(cellFactory);

        userTbl.getColumns().add(actionBtn);

        userTbl.getColumns().setAll(userNameCol, fullNameCol, statusCol, roleCol,actionBtn);

        List<UserModel> users = userDao.findAll();
        FilteredList<UserModel> filteredData = new FilteredList<>(FXCollections.observableArrayList(users), p -> true);

        searchTxt.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(user -> {
            // If filter text is empty, display all users.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare username and full_name of every user with filter text.
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

    private void showAddPersonDialog(Stage parent, final TableView<UserModel> table, double y) {
        // initialize the dialog.
        final Stage dialog = new Stage();
        dialog.setTitle("New Person");
        dialog.initOwner(parent);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setX(parent.getX() + parent.getWidth());
        dialog.setY(y);

        // create a grid for the data entry.
        GridPane grid = new GridPane();
        final TextField userNameField = new TextField();
        final TextField fullNameField = new TextField();
        grid.addRow(0, new Label("User Name"), userNameField);
        grid.addRow(1, new Label("Full Name"), fullNameField);
        grid.setHgap(10);
        grid.setVgap(10);
        GridPane.setHgrow(userNameField, Priority.ALWAYS);
        GridPane.setHgrow(fullNameField, Priority.ALWAYS);

        // create action buttons for the dialog.
        Button ok = new Button("OK");
        ok.setDefaultButton(true);
        Button cancel = new Button("Cancel");
        cancel.setCancelButton(true);

        // only enable the ok button when there has been some text entered.
        ok.disableProperty().bind(userNameField.textProperty().isEqualTo("").or(fullNameField.textProperty().isEqualTo("")));

        // add action handlers for the dialog buttons.
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                int nextIndex = table.getSelectionModel().getSelectedIndex() + 1;
//                table.getItems().add(nextIndex, new UserModel(userNameField.getText(), fullNameField.getText()));
                table.getSelectionModel().select(nextIndex);
                dialog.close();
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                dialog.close();
            }
        });

        /*// layout the dialog.
        HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel).alignment(Pos.CENTER_RIGHT).build();
        VBox layout = new VBox(10);
        layout.getChildren().addAll(grid, buttons);
        layout.setPadding(new Insets(5));
        dialog.setScene(new Scene(layout));
        dialog.show();*/
    }
}
