package com.lwb.pojo;

public class ClassSchedule {
    private String cid;
    private String cnum;
    private String cname;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private String classroomnum;

    public ClassSchedule() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getClassroomnum() {
        return classroomnum;
    }

    public void setClassroomnum(String classroomnum) {
        this.classroomnum = classroomnum;
    }

    @Override
    public String toString() {
        return "ClassSchedule{" +
                "cid='" + cid + '\'' +
                ", cnum='" + cnum + '\'' +
                ", cname='" + cname + '\'' +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", classroomnum='" + classroomnum + '\'' +
                '}';
    }
}
