package com.example.libadmin;


public abstract class People {
    protected String name;
    protected String surname;

    public People(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract void showInfo();
}
