package com.company.model.daoimpl;

import com.company.model.dao.FriendDao;
import com.company.model.entity.Ip;
import com.company.model.entity.User;
import com.company.utils.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peichendong
 */
public class FriendDaoImpl implements FriendDao {

    @Override
    public List< String > getFriends(String id) {
        ArrayList<String> friendIdList = new ArrayList<>();
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select friendId from friends where id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                friendIdList.add(resultSet.getString("friendId"));
            }
            return friendIdList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ip getFriendIps(String id) {
        ArrayList<Ip> friendListIp = new ArrayList<>();
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ip where id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Ip ip = new Ip();
            while (resultSet.next()){
                ip.setId(resultSet.getString("id"));
                ip.setIp(resultSet.getString("address"));
                ip.setPort(resultSet.getInt("port"));
            }
            return ip;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getFriendInfo(String id) {
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                user.setId(resultSet.getString("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassWord(resultSet.getString("password"));
                user.setAutograph(resultSet.getString("autograph"));
                user.setNickName(resultSet.getString("nickname"));
                user.setSex(resultSet.getString("gender"));
                user.setSex(resultSet.getString("phone"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ip getUserIp(String id) {
        Ip ip = new Ip();
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ip where id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ip.setId(resultSet.getString("id"));
                ip.setIp(resultSet.getString("address"));
                ip.setPort(resultSet.getInt("port"));
            }
            return ip;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
