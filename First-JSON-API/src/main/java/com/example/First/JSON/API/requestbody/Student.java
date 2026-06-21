package com.example.First.JSON.API.requestbody;

public class Student {
    private String name;
    private int age;

    // getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
