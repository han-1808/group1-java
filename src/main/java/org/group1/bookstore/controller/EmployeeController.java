package org.group1.bookstore.controller;

import javafx.scene.layout.Region;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.group1.bookstore.view.EmployeeView;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeController {
    private EmployeeView employeeView;
    private Stage stage;

    public EmployeeController(Stage stage) {
        this.stage = stage;
        this.employeeView = new EmployeeView();
    }

    public Region getView() {
        return employeeView.getView(stage);
    }
}
