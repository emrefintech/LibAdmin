package com.example.libadmin;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class BookListWindow {

    private BookOperation bookOperation;

    public BookListWindow(BookOperation bookOperation){
        this.bookOperation = bookOperation;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Book List");

        TableView<Book> table = new TableView<>();
        table.setItems(FXCollections.observableArrayList(bookOperation.getList()));



        TableColumn<Book, Integer> bookIdColumn = new TableColumn<>("Book ID");
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookID"));

        TableColumn<Book, String> bookNameColumn = new TableColumn<>("Book Name");
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, Integer> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));


        table.getColumns().addAll(bookIdColumn, bookNameColumn, authorColumn, dateColumn);




        VBox vbox = new VBox(table);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}

