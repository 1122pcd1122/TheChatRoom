package com.company.views;

import com.company.utils.FriendInfoUtil;
import com.company.utils.UserInfoUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * @author peichendong
 */
public class MainFrame extends JFrame {


    private  JLabel userName;
    private  JLabel userIcon;
    private  JLabel indSign;
    private  JLabel userAccount;
    public   JTree friendList;
    private final JPanel contentPane;
    private JButton addFriend;
    public DefaultMutableTreeNode node;

    public static void main(String[] args) {
        new MainFrame();
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        setBounds(100, 100, 334, 770);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        initView();
        initFriends();

        setVisible(true);
    }

    private void initFriends() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,127,320,606);
        contentPane.add(panel);

        friendList = new JTree();
        node = new DefaultMutableTreeNode("好友列表");
        DefaultTreeModel treeModel = new DefaultTreeModel(node);
        friendList.setModel(treeModel);
        friendList.setBounds(0, 0, 320, 530);
        panel.add(friendList);




        addFriend = new JButton("添加好友");
        addFriend.setFont(new Font("宋体", Font.PLAIN, 12));
        addFriend.setBounds(10,540,100,30);
        panel.add(addFriend);




    }

    private void initView() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 304, 117);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel indSignLabel = new JLabel("个性签名:");
        panel.add(indSignLabel);
        indSignLabel.setBounds(72, 50, 58, 15);

        JLabel userAccountLabel = new JLabel("账号:");
        userAccountLabel.setBounds(72, 75, 58, 15);
        panel.add(userAccountLabel);

        JLabel userNameLabel = new JLabel("用户名:");
        userNameLabel.setBounds(72, 25, 58, 15);
        panel.add(userNameLabel);

        userName = new JLabel(UserInfoUtil.getUser().getNickName());
        userName.setFont(new Font("幼圆", Font.ITALIC, 16));
        userName.setBounds(132, 16, 119, 30);
        panel.add(userName);

        userIcon = new JLabel();
        userIcon.setIcon(new ImageIcon("C:\\Users\\peichendong\\Pictures\\icon2.jpg"));
        userIcon.setBounds(10, 30, 52, 55);
        panel.add(userIcon);

        indSign = new JLabel("DarkHorse");
        indSign.setHorizontalAlignment(SwingConstants.CENTER);
        indSign.setFont(new Font("宋体", Font.PLAIN, 14));
        indSign.setBounds(126, 50, 103, 15);
        panel.add(indSign);

        userAccount = new JLabel(UserInfoUtil.getUser().getId());
        userAccount.setFont(new Font("宋体", Font.BOLD, 14));
        userAccount.setBounds(136, 75, 115, 15);
        panel.add(userAccount);

    }


}
