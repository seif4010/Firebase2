package com.example.firebase2;

public class Student {
    private String name;
    private String year;

    //declare an empty constructor for the firebase to pass data from the database to our properties from the extended node
    public Student(String name, String year){}


    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }


    //getter
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }
}
