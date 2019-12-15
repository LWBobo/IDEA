package com.lwb.pojo;

import java.util.Date;
import java.util.List;

public class Teacher extends Users{
    private String tnum;
    private String tname;
    private String tsex;
    private String ttitle;  //教师职称
    private Date tbirthday;

    private List<Course> courses;   //一位老师可以教授多门课

    public Teacher() {
    }

    public Teacher(String tnum, String tname, String tsex, String ttitle, Date tbirthday) {
        this.tnum = tnum;
        this.tname = tname;
        this.tsex = tsex;
        this.ttitle = ttitle;
        this.tbirthday = tbirthday;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public Date getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tnum='" + tnum + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", ttitle='" + ttitle + '\'' +
                ", tbirthday='" + tbirthday + '\'' +
                '}';
    }
}
