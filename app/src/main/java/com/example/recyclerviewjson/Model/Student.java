package com.example.recyclerviewjson.Model;

public class Student {

    private String  sid;
    private String sname;
    private String gender;

    public Student(String sid, String sname, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
