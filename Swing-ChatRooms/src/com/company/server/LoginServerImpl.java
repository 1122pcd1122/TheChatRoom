package com.company.server;

import com.alibaba.fastjson.JSONObject;
import com.company.model.Login;
import com.company.model.User;
import com.company.server.server.LoginServer;
import com.company.utils.SocketUtil;
import com.company.utils.FriendInfoUtil;
import com.company.utils.UserInfoUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author peichendong
 */
public class LoginServerImpl implements LoginServer {


    /**
     *
     */
    private DatagramSocket socket;
    private String data;
    private Login loginInfo;

    /**
     * 判断是否登录成功
     * 向服务端发送登录页面获取的数据发送到服务端服务端进行逻辑判断返回是否允许登录
     * @param account  账号
     * @param passWord 密码
     * @return 登录状态
     */
    @Override
    public boolean loginIng(String account, String passWord) {
        loginInfo = new Login();
        loginInfo.setAccount(account);
        loginInfo.setPassWord(passWord);

       sendLoginInfo();

        String loginTag = "登录成功";
        return data.equals(loginTag);
    }



    /**
     *发送登录信息
     */
    public void sendLoginInfo(){
        try {
            socket = SocketUtil.getDatagramSocket();

            byte[] jsonLoginInfo = JSONObject.toJSONString(loginInfo).getBytes();
            DatagramPacket packet = new DatagramPacket(jsonLoginInfo,0,jsonLoginInfo.length, InetAddress.getByName("127.0.0.1"),4700);
            socket.send(packet);
            System.out.println("发送成功");

            getLoginStatus();
            getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取登录状态
     */
    public void getLoginStatus(){
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(packet);
            String s = new String(packet.getData(),0,packet.getLength());
            data = JSONObject.parseObject(s, String.class);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取登录的用户信息
     */
    public void getUserInfo(){
        byte[] info = new byte[1024];
        getInfo(info);
    }

    public void getInfo(byte[] info) {
        DatagramPacket packet = new DatagramPacket(info,info.length);
        try {
            socket.receive(packet);
            String userInfo = new String(packet.getData(),0,packet.getLength());
            System.out.println(userInfo);
            UserInfoUtil.user = JSONObject.parseObject(userInfo, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
