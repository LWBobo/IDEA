package com.lwb.pojo;

public class Lab {
    private String labnum;
    private String labname;
    private String labaddress;

    public Lab() {
    }

    public String getLabnum() {
        return labnum;
    }

    public void setLabnum(String labnum) {
        this.labnum = labnum;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getLabaddress() {
        return labaddress;
    }

    public void setLabaddress(String labaddress) {
        this.labaddress = labaddress;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labnum='" + labnum + '\'' +
                ", labname='" + labname + '\'' +
                ", labaddress='" + labaddress + '\'' +
                '}';
    }
}
