package com.cyh;

import lombok.Data;

@Data
public class User {

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
