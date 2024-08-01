package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BookDeleteWindow {
    private BookOperation bookOperations;

    public BookDeleteWindow(BookOperation bookOperations) {
        this.bookOperations = bookOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Delete Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Button deleteButton = new Button("Delete");

        deleteButton.setOnAction(e -> {
            try {
                int bookID = Integer.parseInt(bookIdField.getText());
                bookOperations.deleteBook(bookID);

                if (true) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Book deleted successfully");
                    alert.showAndWait();
                    stage.close();
                } else {
                    throw new Exception("Book not found");
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter a valid Book ID.");
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
        vbox.getChildren().addAll(bookIdLabel, bookIdField, deleteButton);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
