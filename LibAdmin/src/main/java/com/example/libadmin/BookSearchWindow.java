package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BookSearchWindow {
    private BookOperation bookOperations;

    public BookSearchWindow(BookOperation bookOperations) {
        this.bookOperations = bookOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Search Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Button searchButton = new Button("Search");

        searchButton.setOnAction(e -> {
            try {
                int bookID = Integer.parseInt(bookIdField.getText());
                Book book = bookOperations.findBookById(bookID);

                if (book != null) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Book Found");
                    alert.setHeaderText(null);
                    alert.setContentText("Book ID: " + book.getBookID() + "\nTitle: " + book.getBookName() + "\nAuthor: " + book.getAuthor());
                    alert.showAndWait();
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
        vbox.getChildren().addAll(bookIdLabel, bookIdField, searchButton);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.show();
    }
}
