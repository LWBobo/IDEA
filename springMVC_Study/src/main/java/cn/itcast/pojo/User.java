package cn.itcast.pojo;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String password;
    private Integer age;
    private String sex;
    private String address;
    private List<Account> list;
    private Map<String,Account> map;

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public Map<String, Account> getMap() {
        return map;
    }

    public void setMap(Map<String, Account> map) {
        this.map = map;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", paaword='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
