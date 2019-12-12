package com.lwb.pojo;

import java.util.Date;

public class Course {
    private String cnum;
    private String cname;
    private Integer ccredit;   //课程对应的学分
    private Date cbegintime;    //课程开始时间
    private Date cendtime;      //课程结束时间

    public Course() {
    }

    public Course(String cnum, String cname, Integer ccredit, Date cbegintime, Date cendtime) {
        this.cnum = cnum;
        this.cname = cname;
        this.ccredit = ccredit;
        this.cbegintime = cbegintime;
        this.cendtime = cendtime;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    public Date getCbegintime() {
        return cbegintime;
    }

    public void setCbegintime(Date cbegintime) {
        this.cbegintime = cbegintime;
    }

    public Date getCendtime() {
        return cendtime;
    }

    public void setCendtime(Date cendtime) {
        this.cendtime = cendtime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cnum='" + cnum + '\'' +
                ", cname='" + cname + '\'' +
                ", ccredit=" + ccredit +
                ", cbegintime=" + cbegintime +
                ", cendtime=" + cendtime +
                '}';
    }
}
