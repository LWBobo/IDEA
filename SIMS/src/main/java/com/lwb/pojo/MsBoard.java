package com.lwb.pojo;

public class MsBoard {
    private int msid;
    private String uid;
    private String uname;
    private String mstitle;
    private String mskeyword;
    private String mscontents;

    public MsBoard() {
    }

    public MsBoard(int msid, String uid, String uname, String mstitle, String mskeyword, String mscontents) {
        this.msid = msid;
        this.uid = uid;
        this.uname = uname;
        this.mstitle = mstitle;
        this.mskeyword = mskeyword;
        this.mscontents = mscontents;
    }

    public int getMsid() {
        return msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMstitle() {
        return mstitle;
    }

    public void setMstitle(String mstitle) {
        this.mstitle = mstitle;
    }

    public String getMskeyword() {
        return mskeyword;
    }

    public void setMskeyword(String mskeyword) {
        this.mskeyword = mskeyword;
    }

    public String getMscontents() {
        return mscontents;
    }

    public void setMscontents(String mscontents) {
        this.mscontents = mscontents;
    }

    @Override
    public String toString() {
        return "MsBoard{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", mstitle='" + mstitle + '\'' +
                ", mskeyword='" + mskeyword + '\'' +
                ", mscontents='" + mscontents + '\'' +
                '}';
    }
}
