package com.company;

public class User {
    private String name;
    private String password;
    private String email;
    private String telNumber;

    public User() { }

//    public User(String name, String password) {
//        this.name = name;
//        this.password = password;
//    }

    public User(String name, String password, String email, String telNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
