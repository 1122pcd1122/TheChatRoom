package com.company.utils;

import com.company.model.entity.User;

/**
 * @author peichendong
 */
public class UserInfoUtil {
    public static User user;

    public static User getUser(){
        if (user == null){
            user = new User();
        }

        return user;

    }

    @Override
    public String toString() {
        return user.getNickName() + user.getPassWord() + user.getSex() + user.getEmail() + user.getPhoneNumber();
    }
}
