package com.chamodshehanka.madmodelpaper.model;

public class UserModel {
    private int id;
    private String userName;
    private String dob;
    private String gender;

    public UserModel(int id, String userName, String dob, String gender) {
        this.id = id;
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
    }

    public UserModel(String userName, String dob, String gender) {
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
