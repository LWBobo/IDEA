package com.lwb.pojo;

public class Users {
    String uid;
    String upwd;

    public Users(String uid, String upwd) {
        this.uid = uid;
        this.upwd = upwd;
    }

    public Users() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
