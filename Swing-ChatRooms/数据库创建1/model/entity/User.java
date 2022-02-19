package com.company.model.entity;

import java.io.Serializable;

/**
 * @author peichendong
 */
public class User implements Serializable {
    private String id;
    private String autograph;
    private String creatTime;
    private String nickName;
    private String passWord;
    private String phoneNumber;
    private String email;
    private String sex;

    public User() {
    }

    public User(String nickName, String passWord, String phoneNumber, String email, String sex) {
        this.nickName = nickName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
    }

    public User(String id, String autograph, String creatTime, String nickName, String passWord, String phoneNumber, String email, String sex) {
        this.id = id;
        this.autograph = autograph;
        this.creatTime = creatTime;
        this.nickName = nickName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "账号:"+id +",邮箱:"+email +",昵称:"+nickName +",状态:"+autograph +",性别:"+sex;
    }

    public String toString1() {
        return nickName + ',' + passWord + ',' + phoneNumber  + "," + email + "," + sex;
    }

}
