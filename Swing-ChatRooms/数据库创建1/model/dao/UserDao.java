package com.company.model.dao;

import com.company.model.entity.Ip;
import com.company.model.entity.User;

/**
 * @author peichendong
 */
public interface UserDao {
    /**
     * 获取用户信息
     * @param id 账号
     * @param password 密码
     * @return 返回信息查询状态
     */
     boolean getUserInfo(String id, String password);


    /**插入用户信息
     * @param user 用户信息
     * @return 返回插入状态
     */
    boolean insertUserInfo(User user);


    /**插入用户ip
     * @param ip ip地址
     * @return 是否插入
     */
    boolean insertIp(Ip ip);
}
