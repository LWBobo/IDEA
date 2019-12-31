package com.lwb.pojo;

public class LabCourse {
    private String lcnum;
    private String lcname;
    private String lcccnum;
    private String lcccname;
    private String lcclassroomnumber;

    public LabCourse() {
    }


    public String getLcnum() {
        return lcnum;
    }

    public void setLcnum(String lcnum) {
        this.lcnum = lcnum;
    }

    public String getLcname() {
        return lcname;
    }

    public void setLcname(String lcname) {
        this.lcname = lcname;
    }

    public String getLcccnum() {
        return lcccnum;
    }

    public void setLcccnum(String lcccnum) {
        this.lcccnum = lcccnum;
    }

    public String getLcccname() {
        return lcccname;
    }

    public void setLcccname(String lcccname) {
        this.lcccname = lcccname;
    }

    public String getLcclassroomnumber() {
        return lcclassroomnumber;
    }

    public void setLcclassroomnumber(String lcclassroomnumber) {
        this.lcclassroomnumber = lcclassroomnumber;
    }

    @Override
    public String toString() {
        return "LabCourse{" +
                "lcnum='" + lcnum + '\'' +
                ", lcname='" + lcname + '\'' +
                ", lcccnum='" + lcccnum + '\'' +
                ", lcccname='" + lcccname + '\'' +
                ", lcclassroomnumber='" + lcclassroomnumber + '\'' +
                '}';
    }
}
