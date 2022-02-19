package com.company.contorller;

import com.company.server.FriendServer;
import com.company.utils.UserInfoUtil;
import com.company.views.AddFriendsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author peichendong
 */
public class AddFriendController {

    private AddFriendsFrame addFriendsFrame;
    private FriendServer friendServer;

    public static void getAddFriendController(){
        new AddFriendController();
    }

    public AddFriendController() {
        this.addFriendsFrame = new AddFriendsFrame();
        friendServer = new FriendServer();
        addFriendsFrame.addFriendBtn.addActionListener(new AddFriendListener());
    }
    class AddFriendListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean addFriend = isAddFriend();
            if (addFriend){
                System.out.println("添加成功");
                addFriendsFrame.proInfo("添加好友","添加成功");
            }else {
                System.out.println("添加失败");
                addFriendsFrame.proInfo("添加好友","添加失败");
            }
        }
    }


    public boolean isAddFriend(){
        friendServer.sendFriendApply(addFriendsFrame.account.getText()+","+ UserInfoUtil.getUser().getId());
        return friendServer.getApply();
    }
}
