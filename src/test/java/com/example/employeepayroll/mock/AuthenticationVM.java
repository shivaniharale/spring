package com.example.employeepayroll.mock;

public class AuthenticationVM {

    private String user;

    private String pass;

    public AuthenticationVM() {
    }

//    public AuthenticationVM(String user, String pass) {
//        this.user = user;
//        this.pass = pass;
//    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "AuthenticationVM{" +
                       "user='" + user + '\'' +
                       ", pass='" + pass + '\'' +
                       '}';
    }
}
