package com.company.views;

import javax.swing.*;
import java.awt.*;

/**
 * @author peichendong
 */
public class AddFriendsFrame extends JFrame {
    public JTextField account;
    public final JButton addFriendBtn;

    public AddFriendsFrame() {
        setBounds(100, 100, 477, 337);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("账号:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
        lblNewLabel.setBounds(55, 67, 65, 25);
        getContentPane().add(lblNewLabel);

        account = new JTextField();
        account.setBounds(121, 67, 132, 25);
        getContentPane().add(account);
        account.setColumns(10);

        addFriendBtn = new JButton("添加");
        addFriendBtn.setBounds(280, 68, 97, 23);
        getContentPane().add(addFriendBtn);


        this.setVisible(true);

    }

    /**
     * 提示信息框
     */
    public void proInfo(String infoTitle,String info){
        JOptionPane.showMessageDialog(this,info,infoTitle,JOptionPane.WARNING_MESSAGE);
    }

}
