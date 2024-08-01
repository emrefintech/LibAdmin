package com.example.libadmin;

import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookWindow {


    private List<Book> loanBookList = new ArrayList<>();
    private BookOperation bookOperation;
    private LoanOperations loanOperations;
    private UserOperation userOperation;



    public BorrowBookWindow(BookOperation bookOperations, LoanOperations loanOperations, UserOperation userOperation) {
        this.userOperation = userOperation;
        this.loanBookList = loanBookList;
        this.bookOperation = bookOperations;
        this.loanOperations = loanOperations;
    }

    public void show() {

        Stage stage = new Stage();
        stage.setTitle("Loan Book");

        TableView<Book> bookTableView = new TableView<>();




        Label userIdLabel = new Label("User ID:");
        TextField userIdField = new TextField();

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Button loanButton = new Button("Loan");
        loanButton.setOnAction(e -> {
            try {
                int userID = Integer.parseInt(userIdField.getText());
                int bookID = Integer.parseInt(bookIdField.getText());

                boolean userFound = false;
                boolean bookFound = false;

                for (Book book : bookOperation.getList()) {
                    if (book.getBookID() == bookID) {
                        bookFound = true;
                        for (User user : userOperation.getList()) {
                            if (user.getUserID() == userID) {
                                userFound = true;
                                Loan newLoan = new Loan(userID, bookID);
                                loanOperations.addLoan(newLoan);
                                break;
                            }
                        }
                        if (userFound) break;
                    }
                }

                if (!bookFound || !userFound) {
                    throw new Exception("User or Book not found");
                }

                Book bookToRemove = null;

                for (Book book : bookOperation.getList()) {
                    if (book.getBookID() == bookID) {
                        for (User user : userOperation.getList()) {
                            if (user.getUserID() == userID) {
                                Book loanbook = bookOperation.search(bookID);
                                loanBookList.add(loanbook);
                                loanOperations.addLoanBook(loanbook);
                                bookToRemove = book;
                                break;
                            }
                        }
                    }
                }

                if (bookToRemove != null) {
                    bookOperation.getList().remove(bookToRemove);
                    bookTableView.getItems().remove(bookToRemove);
                }

                stage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter valid numerical values for User ID and Book ID.");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });


        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> {
            int userID = Integer.parseInt(userIdField.getText());
            int bookID = Integer.parseInt(bookIdField.getText());

            Loan loanToRemove = null;
            for (Loan loan : loanOperations.getLoanList()) {
                if (loan.getUserID() == userID && loan.getBookID() == bookID) {
                    loanToRemove = loan;
                    break;
                }
            }
            if (loanToRemove != null) {
                loanOperations.removeLoan(loanToRemove);


                Book returnedBook = loanOperations.SearchLoanBook(bookID);

                bookOperation.add(returnedBook);
                bookTableView.getItems().add(returnedBook);
            }

            stage.close();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(userIdLabel, userIdField, bookIdLabel, bookIdField, loanButton,returnButton);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
