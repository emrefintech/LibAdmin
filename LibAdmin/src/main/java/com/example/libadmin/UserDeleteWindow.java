package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserDeleteWindow {
    private UserOperation userOperations;

    public UserDeleteWindow(UserOperation userOperations) {
        this.userOperations = userOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Delete User");

        Label userIdLabel = new Label("User ID:");
        TextField userIdField = new TextField();

        Button deleteButton = new Button("Delete");

        deleteButton.setOnAction(e -> {
            try {
                int userID = Integer.parseInt(userIdField.getText());

                userOperations.delete(userID);
                if (true) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("User deleted successfully");
                    alert.showAndWait();
                    stage.close();
                } else {
                    throw new Exception("User not found");
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter a valid numerical value for User ID.");
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
        vbox.getChildren().addAll(userIdLabel, userIdField, deleteButton);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
