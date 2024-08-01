package com.example.libadmin;


import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class UserListWindow {

    private UserOperation userOperation;

    public UserListWindow(UserOperation userOperation){
        this.userOperation = userOperation;
    }

    public void show() {
        Stage stage = new Stage();

        TableView<User> table = new TableView<>();
        table.setItems(FXCollections.observableArrayList(userOperation.getList()));

        stage.setTitle("User List");



        TableColumn<User, Integer> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<User, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.getColumns().addAll(userIdColumn, nameColumn, surnameColumn, dateColumn);



        VBox vbox = new VBox(table);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
