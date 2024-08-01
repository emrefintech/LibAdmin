package com.example.libadmin;


public class User extends People {
    private int userID;
    private int date;

    public User(int userID, String name, String surname, int date) {
        super(name, surname);
        this.userID = userID;
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public int getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setUserID(int userID){this.userID=userID;}
    public void setName(String name){this.name=name;}
    public void setSurname(String surname){this.surname=surname;}
    public void setDate(int date){this.date=date;}

    @Override
    public void showInfo() {
        System.out.println("User ID: " + userID + ", Name: " + name + ", Surname: " + surname + ", Date: " + date);
    }
}