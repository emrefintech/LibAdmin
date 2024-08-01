package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BookUpdateWindow {
    private BookOperation bookOperations;

    public BookUpdateWindow(BookOperation bookOperations) {
        this.bookOperations = bookOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Update Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();

        Label yearLabel = new Label("Year:");
        TextField yearField = new TextField();

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            try {
                int bookID = Integer.parseInt(bookIdField.getText());
                String title = titleField.getText();
                String author = authorField.getText();
                int year = Integer.parseInt(yearField.getText());

                if (title.isEmpty() || author.isEmpty()) {
                    throw new IllegalArgumentException("Title and Author cannot be empty.");
                }

                bookOperations.updateBook(bookID, title, author, year);

                if (true) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Book updated successfully");
                    alert.showAndWait();
                    stage.close();
                } else {
                    throw new Exception("Book not found");
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter valid numerical values for Book ID and Year.");
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
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });





        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(bookIdLabel, bookIdField, titleLabel, titleField, authorLabel, authorField, yearLabel, yearField, updateButton);

        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
