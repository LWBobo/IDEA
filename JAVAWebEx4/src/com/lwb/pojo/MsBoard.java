package com.lwb.pojo;

public class MsBoard {
    private int uid;
    private String uname;
    private String mstitle;
    private String mskeyword;
    private String msinfo;

    public MsBoard(int uid, String uname, String mstitle, String mskeyword, String msinfo) {
        this.uid = uid;
        this.uname = uname;
        this.mstitle = mstitle;
        this.mskeyword = mskeyword;
        this.msinfo = msinfo;
    }

    public MsBoard() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public String getMstitle() {
        return mstitle;
    }

    public String getMskeyword() {
        return mskeyword;
    }

    public String getMsinfo() {
        return msinfo;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setMstitle(String mstitle) {
        this.mstitle = mstitle;
    }

    public void setMskeyword(String mskeyword) {
        this.mskeyword = mskeyword;
    }

    public void setMsinfo(String msinfo) {
        this.msinfo = msinfo;
    }
}
