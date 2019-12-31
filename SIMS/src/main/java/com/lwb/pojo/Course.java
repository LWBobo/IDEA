package com.lwb.pojo;

import java.util.Date;
import java.util.List;

public class Course {
    private String cnum;
    private String cname;
    private Integer ccredit;   //课程对应的学分
    private Date cbegintime;    //课程开始时间
    private Date cendtime;      //课程结束时间
    private int cislabcourse; //是否有实验课

    private Teacher teacher;    //一门课有一位老师

    List<Student> students;        //一门课有多个学生选修

    private int cgrade;    //课程成绩,只有在学生中才有效

    private LabCourse labcourse;   //实验课,只有老师安排实验课的时候有效,并且需要输出.

    public Course() {
    }

    public Course(String cnum, String cname, Integer ccredit, Date cbegintime, Date cendtime) {
        this.cnum = cnum;
        this.cname = cname;
        this.ccredit = ccredit;
        this.cbegintime = cbegintime;
        this.cendtime = cendtime;
    }

    public int getCislabcourse() {
        return cislabcourse;
    }

    public void setCislabcourse(int cislabcourse) {
        this.cislabcourse = cislabcourse;
    }

    public LabCourse getLabcourse() {
        return labcourse;
    }

    public void setLabcourse(LabCourse labcourse) {
        this.labcourse = labcourse;
    }

    public int getCgrade() {
        return cgrade;
    }

    public void setCgrade(int cgrade) {
        this.cgrade = cgrade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
