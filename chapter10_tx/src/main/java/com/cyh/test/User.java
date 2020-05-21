package com.cyh.test;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    public User(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
