package com.lwb.pojo;

public class Teacher {
    private String tnum;
    private String tname;
    private String tsex;
    private String ttitle;  //教师职称
    private String tbirthday;

    public Teacher() {
    }

    public Teacher(String tnum, String tname, String tsex, String ttitle, String tbirthday) {
        this.tnum = tnum;
        this.tname = tname;
        this.tsex = tsex;
        this.ttitle = ttitle;
        this.tbirthday = tbirthday;
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

    public String getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(String tbirthday) {
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
