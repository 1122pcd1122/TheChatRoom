package com.company.model.entity;

/**
 * @author peichendong
 */
public class Login {
    private String account;
    private String passWord;

    public Login() {
    }

    public Login(String account, String passWord) {
        this.account = account;
        this.passWord = passWord;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
