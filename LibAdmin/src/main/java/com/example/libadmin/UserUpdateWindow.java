package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserUpdateWindow {
    private UserOperation userOperations;

    public UserUpdateWindow(UserOperation userOperations) {
        this.userOperations = userOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Update User");

        Label userIdLabel = new Label("User ID:");
        TextField userIdField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label surnameLabel = new Label("Surname:");
        TextField surnameField = new TextField();

        Label dateLabel = new Label("Date:");
        TextField dateField = new TextField();

        Button updateButton = new Button("Update");

        updateButton.setOnAction(e -> {
            try {
                int userID = Integer.parseInt(userIdField.getText());
                String name = nameField.getText();
                String surname = surnameField.getText();
                int date = Integer.parseInt(dateField.getText());

                // Verilerin doğruluğunu kontrol ediyoruz
                if (name.isEmpty() || surname.isEmpty()) {
                    throw new IllegalArgumentException("Name and Surname cannot be empty.");
                }

                userOperations.updateUser(userID, name, surname, date);
                if (true) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("User updated successfully");
                    alert.showAndWait();
                    stage.close();
                } else {
                    throw new Exception("User not found");
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter valid numerical values for User ID and Date.");
                alert.showAndWait();
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User not found or invalid input");
                alert.showAndWait();
            }
        });



        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(userIdLabel, userIdField, nameLabel, nameField, surnameLabel, surnameField, dateLabel, dateField, updateButton);

        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
