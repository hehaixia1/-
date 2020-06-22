package com.example.t1.ui.login;

public class User {
    private String userName;            //用户名
    private String password;        //密码
    public User(String name, String password) {
        this.userName = name;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        this.userName = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
