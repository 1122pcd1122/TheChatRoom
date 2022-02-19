package com.company.model.dao;

import com.company.model.entity.Ip;
import com.company.model.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author peichendong
 */
public interface FriendDao {
    /**
     * 获取好友列表
     * @param id 用户账号
     * @return 返回用户的好友列表
     */
    List<String> getFriends(String id);

    /**
     * 获取好友的ip
     * @param id 账号
     * @return 返回IP地址
     */
    Ip getFriendIps(String id);

    /**
     * 获取好友的信息
     * @param id 账号
     * @return 返回用户信息
     */
    User getFriendInfo(String id);

    /**
     * 获取用户䣌ip信息
     * @param id 账号
     * @return 返回ip
     */
    Ip getUserIp(String id);

    /**
     * 添加好友
     * @param userId 用户id
     * @param fiendId 好友id
     * @return 是否添加
     */
    boolean insertFriend(String userId,String fiendId);

}
