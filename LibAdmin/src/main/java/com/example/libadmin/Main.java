package com.example.libadmin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BookOperation bookOperation = new BookOperation();
        UserOperation userOperation =  new UserOperation();
        LoanOperations loanOperations = new LoanOperations();


        primaryStage.setTitle("Library Management System");


        Button bookAddButton = new Button("Add Book");
        Button deleteBookButton = new Button("Delete Book");
        Button updateBookButton = new Button("Update Book");
        Button userAddButton = new Button("Add User");
        Button deleteUserButton = new Button("Delete User");
        Button updateUserButton = new Button("Update User");
        Button bookListButton = new Button("Book List");
        Button userListButton = new Button("User List");
        Button borrowButton = new Button("Book Borrowing/Returning");
        Button statsButton = new Button("Borrowers List");
        Button statisticsButton = new Button("Statistics");
        Button searchBookButton = new Button("Search Book");
        Button searchUserButton = new Button("Search User");



        bookAddButton.setOnAction(e -> {
            BookWindow bookWindow = new BookWindow(bookOperation);
            bookWindow.show();
        });
        deleteBookButton.setOnAction(e -> {
            BookDeleteWindow bookDeletionWindow = new BookDeleteWindow(bookOperation);
            bookDeletionWindow.show();
        });

        updateBookButton.setOnAction(e -> {
            BookUpdateWindow bookUpdateWindow = new BookUpdateWindow(bookOperation);
            bookUpdateWindow.show();
        });

        userAddButton.setOnAction(e -> {
            UserAddWindow userAddWindow = new UserAddWindow(userOperation);
            userAddWindow.show();
        });

        bookListButton.setOnAction(e -> {
            BookListWindow bookListWindow = new BookListWindow(bookOperation);
            bookListWindow.show();
        });

        userListButton.setOnAction(e -> {
            UserListWindow userListWindow = new UserListWindow(userOperation);
            userListWindow.show();
        });

        borrowButton.setOnAction(e -> {

            BorrowBookWindow borrowWindow = new BorrowBookWindow(bookOperation,loanOperations,userOperation);
            borrowWindow.show();
        });

        statsButton.setOnAction(e -> {
            StatWindow statsWindow = new StatWindow(loanOperations);
            statsWindow.show();
        });
        deleteUserButton.setOnAction(e -> {
            UserDeleteWindow userDeletionWindow = new UserDeleteWindow(userOperation);
            userDeletionWindow.show();
        });

        updateUserButton.setOnAction(e -> {
            UserUpdateWindow userUpdateWindow = new UserUpdateWindow(userOperation);
            userUpdateWindow.show();
        });

        statisticsButton.setOnAction(e -> {
            StatLibWindow statLibWindow = new StatLibWindow(bookOperation, loanOperations);
            statLibWindow.show();
        });

        searchBookButton.setOnAction(e -> {
            BookSearchWindow bookSearchWindow = new BookSearchWindow(bookOperation);
            bookSearchWindow.show();
        });

        searchUserButton.setOnAction(e -> {
            UserSearchWindow userSearchWindow = new UserSearchWindow(userOperation);
            userSearchWindow.show();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(bookAddButton,deleteBookButton,updateBookButton, userAddButton,deleteUserButton, updateUserButton, bookListButton, userListButton, borrowButton, statsButton,statisticsButton,searchBookButton,searchUserButton);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
