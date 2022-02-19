package com.company.utils;

import com.company.model.User;

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
}
