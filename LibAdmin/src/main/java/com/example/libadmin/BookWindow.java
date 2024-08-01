package com.example.libadmin;


import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class BookWindow {

    public BookOperation bookOperations;


    public BookWindow (BookOperation bookOperations) {
        this.bookOperations = bookOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Add Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Label bookTitleLabel = new Label("Book Title:");
        TextField bookTitleField = new TextField();

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();

        Label publishYearLabel = new Label("Publish Year:");
        TextField publishYearField = new TextField();

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                int bookID = Integer.parseInt(bookIdField.getText());
                String bookTitle = bookTitleField.getText();
                String author = authorField.getText();
                int publishYear = Integer.parseInt(publishYearField.getText());

                Book existingBook = bookOperations.search(bookID);
                if (existingBook != null) {
                    throw new IllegalArgumentException("Book already exists with this ID.");
                }

                if (bookTitle.isEmpty() || author.isEmpty()) {
                    throw new IllegalArgumentException("Book Title and Author cannot be empty.");
                }

                Book newBook = new Book(bookID, bookTitle, author, publishYear);
                bookOperations.add(newBook);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Book added successfully");
                alert.showAndWait();

                stage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter valid numerical values for Book ID and Publish Year.");
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
                alert.setContentText("An error occurred while adding the book.");
                alert.showAndWait();
            }
        });



        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(bookIdLabel, bookIdField, bookTitleLabel, bookTitleField, authorLabel, authorField, publishYearLabel, publishYearField, saveButton);

        Scene scene = new Scene(vbox, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
