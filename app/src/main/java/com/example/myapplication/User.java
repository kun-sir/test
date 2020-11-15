package com.example.myapplication;

import androidx.databinding.Bindable;

public class User {
    String name;
    int age;

    public String getName() {
        return name;
    }
    @Bindable
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @Bindable
    public void setAge(int age) {
        this.age = age;
    }
}
