package com.example.students.model;

public class Student {
    public String id;
    public String name;
    public String avatarUrl;
    public String phoneNumber;
    public String address;
    public boolean checkStatus;

    public Student(String id, String name, String phoneNumber, String address, boolean checkStatus){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.checkStatus = checkStatus;
        this.avatarUrl = "";
    }

}
