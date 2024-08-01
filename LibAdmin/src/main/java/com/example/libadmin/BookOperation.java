package com.example.libadmin;



import java.util.ArrayList;
import java.util.List;

public class BookOperation implements IOperation<Book> {
    private List<Book> bookList;



    public BookOperation() {
        bookList = new ArrayList<>();

    }


    public void deleteBook(int bookID) throws Exception {
        Book bookToRemove = null;
        for (Book book : bookList) {
            if (book.getBookID() == bookID) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            bookList.remove(bookToRemove);
        } else {
            throw new Exception("Book not found");
        }
    }

    public void updateBook(int bookID, String bookName, String author, int date) throws Exception {
        Book bookToUpdate = null;
        for (Book book : bookList) {
            if (book.getBookID() == bookID) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate != null) {
            bookToUpdate.setBookName(bookName);
            bookToUpdate.setAuthor(author);
            bookToUpdate.setDate(date);
        } else {
            throw new Exception("Book not found");
        }
    }

    @Override
    public void add(Book book) {
        bookList.add(book);
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookID() == book.getBookID()) {
                bookList.set(i, book);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        bookList.removeIf(k -> k.getBookID() == id);
    }

    @Override
    public Book search(int id) {
        for (Book k : bookList) {
            if (k.getBookID() == id) {
                return k;
            }
        }
        return null;
    }
    public Book findBookById(int bookID) {
        for (Book book : bookList) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getList() {
        return bookList;
    }
}
