package com.annie.annieforchild.entity;

/**
 * Created by shen
 * on 2019/8/30
 */


public class StudentBean {

    public  int  age ;
    public  String name;

    public StudentBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
