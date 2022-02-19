package com.company.model.daoimpl;

import com.company.model.dao.UserDao;
import com.company.model.entity.Ip;
import com.company.model.entity.User;
import com.company.utils.IpUtil;
import com.company.utils.JdbcUtil;
import com.company.utils.UserInfoUtil;

import java.sql.*;

/**
 * @author peichendong
 */
public class UserDaoImpl implements UserDao {
    /**
     * @param id 账号
     * @param passWord 密码
     * @return
     */
    @Override
    public boolean getUserInfo(String id, String passWord) {

        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ? and password = ?");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,passWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                UserInfoUtil.getUser().setId(resultSet.getString("id"));
                UserInfoUtil.getUser().setEmail(resultSet.getString("email"));
                UserInfoUtil.getUser().setPassWord(resultSet.getString("password"));
                UserInfoUtil.getUser().setNickName(resultSet.getString("nickname"));
                UserInfoUtil.getUser().setAutograph(resultSet.getString("autograph"));
                UserInfoUtil.getUser().setSex(resultSet.getString("gender"));
                UserInfoUtil.getUser().setPhoneNumber(resultSet.getString("phone"));
            }
            return passWord.equals(UserInfoUtil.getUser().getPassWord());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @param user 用户信息
     * @return 登录状态
     */
    @Override
    public boolean insertUserInfo(User user) {
        Date d = new Date(System.currentTimeMillis());
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id,email,password,nickname,autograph,create_time,gender,phone) value(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassWord());
            preparedStatement.setString(4,user.getNickName());
            preparedStatement.setString(5,"在线");
            preparedStatement.setDate(6,d);
            preparedStatement.setString(7,user.getSex());
            preparedStatement.setString(8,user.getPhoneNumber());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean insertIp(Ip ip) {
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ip(id,address,port) value(?,?,?)");
            preparedStatement.setString(1, IpUtil.getIp().getId());
            preparedStatement.setString(2,IpUtil.getIp().getIp());
            preparedStatement.setInt(3,IpUtil.getIp().getPort());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }




}
