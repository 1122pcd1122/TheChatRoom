package com.company.server.server;

import com.company.model.User;

/**
 * @author peichendong
 */
public interface RegisterServer {

    /**
     * 注册...
     * @param user 注册用户信息
     * @return 注册状态
     */
    boolean registerIng(User user);


}
