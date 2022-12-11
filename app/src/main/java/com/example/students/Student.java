package com.example.students;

public class Student {
    String id;
    String name;
    String image;
    String phoneNumber;
    String address;
    boolean checkStatus;

    public Student(String id, String name, String image, String phoneNumber, String address, boolean checkStatus){
        this.id = id;
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.checkStatus = checkStatus;
    }

}
