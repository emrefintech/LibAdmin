package com.example.libadmin;

public class Loan {
    private int userID;
    private int bookID;

    public Loan(int userID, int bookID) {
        this.userID = userID;
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
