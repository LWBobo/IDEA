package com.lwb.entity;


import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private int jeescore;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJeescore() {
        return jeescore;
    }

    public void setJeescore(int jeescore) {
        this.jeescore = jeescore;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", jeescore=" + jeescore +
                '}';
    }
}
