package com.example.libadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class StatWindow {
    private LoanOperations loanOperations;

    public StatWindow(LoanOperations loanOperations) {
        this.loanOperations = loanOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Loan Statistics");

        TableView<Loan> tableView = new TableView<>();
        ObservableList<Loan> data = FXCollections.observableArrayList(loanOperations.getLoanList());

        TableColumn<Loan, Integer> userIDColumn = new TableColumn<>("User ID");
        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));

        TableColumn<Loan, Integer> bookIDColumn = new TableColumn<>("Book ID");
        bookIDColumn.setCellValueFactory(new PropertyValueFactory<>("bookID"));

        tableView.setItems(data);
        tableView.getColumns().addAll(userIDColumn, bookIDColumn);




        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
