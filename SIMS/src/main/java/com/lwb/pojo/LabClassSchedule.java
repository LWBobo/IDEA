package com.lwb.pojo;

public class LabClassSchedule {
    private int lcid;
    private String lcnum;
    private String lcname;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;

    public LabClassSchedule() {
    }

    public int getLcid() {
        return lcid;
    }

    public void setLcid(int lcid) {
        this.lcid = lcid;
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

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    @Override
    public String toString() {
        return "LabClassSchedule{" +
                "lcid=" + lcid +
                ", lcnum='" + lcnum + '\'' +
                ", lcname='" + lcname + '\'' +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                '}';
    }
}
