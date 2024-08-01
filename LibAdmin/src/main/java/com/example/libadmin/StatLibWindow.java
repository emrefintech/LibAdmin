package com.example.libadmin;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StatLibWindow {
    private BookOperation bookOperations;
    private LoanOperations loanOperations;

    public StatLibWindow(BookOperation bookOperations, LoanOperations loanOperations) {
        this.bookOperations = bookOperations;
        this.loanOperations = loanOperations;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Library Statistics");

        int totalBooks = bookOperations.getList().size();
        int borrowedBooks = loanOperations.getLoanList().size();

        totalBooks = totalBooks+borrowedBooks;
        double borrowedPercentage = 0.0;

        if (totalBooks > 0) {
            borrowedPercentage = ((double) borrowedBooks / (totalBooks)) * 100;
        }

        Label totalBooksLabel = new Label("Total Books: " + (totalBooks));
        Label borrowedBooksLabel = new Label("Borrowed Books: " + borrowedBooks);
        Label borrowedPercentageLabel = new Label(String.format("Percentage of Books Borrowed: %.2f%%", borrowedPercentage));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(totalBooksLabel, borrowedBooksLabel, borrowedPercentageLabel);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
