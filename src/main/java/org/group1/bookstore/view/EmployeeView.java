package org.group1.bookstore.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import org.group1.bookstore.dao.BookDao;
import org.group1.bookstore.dao.impl.BookDaoImpl;
import org.group1.bookstore.dto.enumtype.HotNew;
import org.group1.bookstore.dto.enumtype.OutOfStock;
import org.group1.bookstore.model.BookModel;

import java.util.List;

@Getter
@Setter
public class EmployeeView {
    private BookDao bookDao = new BookDaoImpl();
    public Region getView(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Employee Page");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        //TODO: Task 29:  View list of book authors. Search or sort on the list
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(getTabViewBook());

        grid.add(tabPane, 0, 1);

        Button button = new Button();
        button.setText("Logout");
        button.setOnAction(event -> {
            stage.setScene(new Scene(new UserController(stage).getView(), 300, 275));
            stage.show();
        });
        grid.add(button, 1, 12);

        return new VBox(grid);
    }

    private Tab getTabViewBook() {
        Tab tabViewBook = new Tab("View Book", new Label("View a list of books"));
        tabViewBook.setClosable(false);

        Pane pane = new Pane();

        TextField searchTxt = new TextField();
        searchTxt.setPromptText("Nhập Tên sách");
        pane.getChildren().add(searchTxt);

        TableView<BookModel> bookTbl = getTableBook(searchTxt);
        bookTbl.relocate(0, 30);

        pane.getChildren().add(bookTbl);

        tabViewBook.setContent(pane);

        return tabViewBook;
    }

    private TableView<BookModel> getTableBook(TextField searchTxt) {
        TableView<BookModel> bookTbl = new TableView<>();

        TableColumn<BookModel, String> nameCol = new TableColumn<>("Tên sách");
        TableColumn<BookModel, String> priceCol = new TableColumn<>("Giá bán");
        TableColumn<BookModel, String> categoryCol = new TableColumn<>("Mục sách");
        TableColumn<BookModel, String> publisherCol = new TableColumn<>("Nhà xuất bản");
        TableColumn<BookModel, String> authorCol = new TableColumn<>("Tác giả");
        TableColumn<BookModel, String> hotNewCol = new TableColumn<>("Hot New");
        TableColumn<BookModel, String> stockCol = new TableColumn<>("Tình trạng");

        nameCol.setCellValueFactory(book -> new SimpleStringProperty(book.getValue().getName()));
        priceCol.setCellValueFactory(book -> new SimpleStringProperty(book.getValue().getImport_price().toString()));
        categoryCol.setCellValueFactory(book -> new SimpleStringProperty(book.getValue().getCategory()));
        publisherCol.setCellValueFactory(book -> new SimpleStringProperty(book.getValue().getPublisher()));
        authorCol.setCellValueFactory(book -> new SimpleStringProperty(book.getValue().getAuthor()));
        hotNewCol.setCellValueFactory(book -> new SimpleStringProperty(HotNew.getHotNewContent(book.getValue().getHot_new())));
        stockCol.setCellValueFactory(book -> new SimpleStringProperty(OutOfStock.getOutOfStockContent(book.getValue().getOut_of_stock())));

        bookTbl.getColumns().setAll(nameCol, priceCol, categoryCol, publisherCol, authorCol, hotNewCol, stockCol);

        List<BookModel> books = bookDao.findAll();
        FilteredList<BookModel> filteredData = new FilteredList<>(FXCollections.observableArrayList(books), p -> true);

        searchTxt.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(user -> {
            // If filter text is empty, display all books.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare name of every book with filter text.
            String lowerCaseFilter = newValue.toLowerCase().trim();

            if (user.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches book name.
            }
            return user.getName().toLowerCase().contains(lowerCaseFilter); // Filter matches name.
        }));

        SortedList<BookModel> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(bookTbl.comparatorProperty());

        bookTbl.setItems(sortedData);
        return bookTbl;
    }
}
