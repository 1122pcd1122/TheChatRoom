package com.company.server.server;

/**
 * @author peichendong
 */
public interface LoginServer {
    /**
     * loginIng......
     * @param account 账号
     * @param passWord 密码
     * @return 返回登录状态
     */
     boolean loginIng(String account,String passWord);
}
