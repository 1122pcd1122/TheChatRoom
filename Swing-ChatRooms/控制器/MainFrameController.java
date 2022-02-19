package com.company.contorller;

import com.alibaba.fastjson.JSONArray;
import com.company.model.Ip;
import com.company.model.User;
import com.company.server.FriendServer;
import com.company.utils.IpUtil;
import com.company.utils.FriendInfoUtil;
import com.company.views.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;

/**
 * @author peichendong
 */
public class MainFrameController {


    private final MainFrame mainFrame;
    private final FriendServer friendServer;
    private List<User> userList;
    private List<Ip> ipList;

    public static void getMainFrameController() {
        new MainFrameController();
    }

    public MainFrameController() {
        mainFrame = new MainFrame();
        friendServer = new FriendServer();
        configFriend();
        mainFrame.friendList.addTreeSelectionListener(new SelectListener());
    }

    public void configFriend(){
        String friendsInfo = friendServer.getFriendsInfo();
        String friendsIp = friendServer.getFriendsIp();

        JSONArray jsonInfoArray = JSONArray.parseArray(friendsInfo);
        userList = new ArrayList<>();
        for (int i = 0; i < jsonInfoArray.size(); i++) {
            User user = jsonInfoArray.getObject(i,User.class);
            userList.add(user);
        }
        JSONArray jsonIpArray = JSONArray.parseArray(friendsIp);

        ipList = new ArrayList<>();
        for (int i = 0; i < jsonIpArray.size(); i++) {
            Ip object = jsonIpArray.getObject(i, Ip.class);
            ipList.add(object);
        }
        for (User user : userList) {
            mainFrame.node.add(new DefaultMutableTreeNode(user.getNickName()));
        }

    }

    class SelectListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) mainFrame.friendList.getLastSelectedPathComponent();
            if (dmt.isLeaf()){
                int index = mainFrame.node.getIndex(dmt);
                User user = userList.get(index);
                Ip ip = ipList.get(index);
                FriendInfoUtil.user = user;
                IpUtil.ip = ip;
                ChatFrameController.getChatFrameController();
            }
        }
    }

}
