package com.lwb.pojo;

public class Users {
    String uid;
    String upwd;
    String uname;

    public Users(String uid, String upwd) {
        this.uid = uid;
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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
                ", uname='" + uname + '\'' +
                '}';
    }
}
