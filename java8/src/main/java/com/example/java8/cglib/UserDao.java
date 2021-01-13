package com.example.java8.cglib;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("test");
    }
}
