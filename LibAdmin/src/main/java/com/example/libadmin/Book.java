package com.example.libadmin;



public class Book {

    public int bookID;
    public String bookName;
    public String author;
    public int date;

    public Book(int bookID, String bookName, String author, int date) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.date = date;
    }



    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }
    public String getAuthor(){
        return author;
    }

    public int getDate(){
        return date;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public void setDate(int date){
        this.date = date;
    }

    public void showInfo() {
        System.out.println("Book ID: " + bookID + ", Book Name: " + bookName + ", Author: " + author + ", Date: " + date);
    }
}
