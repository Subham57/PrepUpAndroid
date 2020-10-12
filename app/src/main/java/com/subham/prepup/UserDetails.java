package com.subham.prepup;

public class UserDetails {

    private String fname;
    private String mname;
    private String lname;
    private long phnumber;
    private String emailid;
    private String password;
    private String instname;
    private int userid;
    private String role;

    public UserDetails(){super();}

    public UserDetails(String fname, String mname, String lname, long phnumber, String emailid, String password, String instname, int userid, String role) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.phnumber = phnumber;
        this.emailid = emailid;
        this.password = password;
        this.instname = instname;
        this.userid = userid;
        this.role = role;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public long getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(long phnumber) {
        this.phnumber = phnumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstname() {
        return instname;
    }

    public void setInstname(String instname) {
        this.instname = instname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
