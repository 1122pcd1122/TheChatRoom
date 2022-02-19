package com.company.utils;

import com.company.model.Ip;

/**
 * @author peichendong
 */
public class IpUtil {
    public static Ip ip;

    public static Ip getIp() {
        if (ip == null){
            ip = new Ip();
        }
        return ip;
    }
}
