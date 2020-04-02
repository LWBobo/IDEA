package com.lwb.entity;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Student implements Serializable {
    @NotBlank(message = "{id.notnull}")
    private String id;
    @NotBlank(message = "{name.notnull}")
    private String name;
    @NotNull(message = "{age.notnull}")
    @Digits(integer = 3,fraction = 0,message = "只能输入数字")
    @Min(value = 1,message = "{age.min}")
    @Max(value = 150,message = "{age.max}")
    private Integer age;
    @NotBlank(message = "{sex.notnull}")
    private String sex;
    @NotBlank(message = "{address.notnull}")
    private String address;
    @NotNull(message = "{jeescore.notnull}")
    @Min(value = 0,message = "{jeescore.min}")
    @Max(value = 100,message = "{jeescore.max}")
    private Integer jeescore;
    private String password;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Integer getJeescore() {
        return jeescore;
    }

    public void setJeescore(Integer jeescore) {
        this.jeescore = jeescore;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                '}';
    }
}
