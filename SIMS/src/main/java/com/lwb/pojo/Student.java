package com.lwb.pojo;

import java.util.Date;
import java.util.List;

public class Student extends Users{
    private String snum;
    private String sname;
    private String ssex;
    private String stel;
    private String saddress;
    private Date sbirthday;

    private List<Course> courses;

    public Student(){
    }

    public Student(String snum, String sname, String ssex, String stel, String saddress, Date sbirthday) {
        this.snum = snum;
        this.sname = sname;
        this.ssex = ssex;
        this.stel = stel;
        this.saddress = saddress;
        this.sbirthday = sbirthday;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", stel='" + stel + '\'' +
                ", saddress='" + saddress + '\'' +
                ", sbirthday=" + sbirthday +
                '}';
    }
}
