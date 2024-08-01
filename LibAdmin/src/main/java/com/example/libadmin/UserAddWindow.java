package com.example.libadmin;


import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserAddWindow {

    public UserOperation userOperation;

    public UserAddWindow (UserOperation userOperation) {
        this.userOperation = userOperation;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Add User");

        Label userIdLabel = new Label("User ID:");
        TextField userIdField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label surnameLabel = new Label("Surname:");
        TextField surnameField = new TextField();

        Label dateLabel = new Label("Date:");
        TextField dateField = new TextField();

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                int userID = Integer.parseInt(userIdField.getText());
                String name = nameField.getText();
                String surname = surnameField.getText();
                int date = Integer.parseInt(dateField.getText());

                User existingUser = userOperation.search(userID);
                if (existingUser != null) {
                    throw new IllegalArgumentException("User already exists with this ID.");
                }

                if (name.isEmpty() || surname.isEmpty()) {
                    throw new IllegalArgumentException("Name and Surname cannot be empty.");
                }



                User newUser = new User(userID, name, surname, date);
                userOperation.add(newUser);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("User added successfully");
                alert.showAndWait();

                stage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter valid numerical values for User ID and Date.");
                alert.showAndWait();
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while adding the user.");
                alert.showAndWait();
            }
        });



        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(userIdLabel, userIdField, nameLabel, nameField, surnameLabel, surnameField, dateLabel, dateField, saveButton);

        Scene scene = new Scene(vbox, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
