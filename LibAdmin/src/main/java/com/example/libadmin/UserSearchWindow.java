package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserSearchWindow {
    private UserOperation userOperations;

    public UserSearchWindow(UserOperation userOperations) {
        this.userOperations = userOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Search User");

        Label userIdLabel = new Label("User ID:");
        TextField userIdField = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            try {
                int userID = Integer.parseInt(userIdField.getText());
                User user = userOperations.findUserById(userID);

                if (user != null) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("User Found");
                    alert.setHeaderText(null);
                    alert.setContentText("User ID: " + user.getUserID() + "\nName: " + user.getName() + "\nSurname: " + user.getSurname() + "\nDate: " + user.getDate());
                    alert.showAndWait();
                } else {
                    throw new Exception("User not found");
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter a valid User ID.");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });


        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(userIdLabel, userIdField, searchButton);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.show();
    }
}
