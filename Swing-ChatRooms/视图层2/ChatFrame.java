package com.company.views;



import com.company.utils.IpUtil;
import com.company.utils.FriendInfoUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author peichendong
 */
public class ChatFrame extends JFrame {
    public JTextArea sendTeArea;
    public JTextArea receiveArea;
    public JButton sendBtn;
    public JButton shutDownBtn;
    public JLabel userName;
    public JLabel account;
    public JLabel ip;
    public JLabel port;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new ChatFrame();
    }

    /**
     * Create the frame.
     */
    public ChatFrame() {
        setBounds(100, 100, 740, 610);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 304, 726, 259);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 726, 301);
        contentPane.add(panel1);
        panel1.setLayout(null);

        initInnerView(panel1);

        initOutView(panel, panel1);

        setVisible(true);
    }

    private void initOutView(JPanel panel, JPanel panel1) {
        shutDownBtn = new JButton("关闭");
        shutDownBtn.setBounds(536, 215, 80, 35);
        panel.add(shutDownBtn);

        sendBtn = new JButton("发送");
        sendBtn.setBounds(626, 215, 80, 35);
        panel.add(sendBtn);

        sendTeArea = new JTextArea();
        sendTeArea.setBounds(0, 0, 726, 210);
        panel.add(sendTeArea);

        receiveArea = new JTextArea();
        receiveArea.setBounds(0, 37, 726, 264);
        panel1.add(receiveArea);

        userName = new JLabel(FriendInfoUtil.getUser().getNickName());
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setFont(new Font("宋体", Font.PLAIN, 14));
        userName.setBounds(67, 12, 60, 20);
        panel1.add(userName);

        account = new JLabel(FriendInfoUtil.getUser().getId());
        account.setHorizontalAlignment(SwingConstants.LEFT);
        account.setFont(new Font("宋体", Font.PLAIN, 14));
        account.setBounds(190, 12, 103, 20);
        panel1.add(account);

        ip = new JLabel(IpUtil.getIp().getIp());
        ip.setHorizontalAlignment(SwingConstants.LEFT);
        ip.setFont(new Font("宋体", Font.PLAIN, 14));
        ip.setBounds(361, 12, 103, 20);
        panel1.add(ip);


        port = new JLabel(String.valueOf(IpUtil.getIp().getPort()));
        port.setHorizontalAlignment(SwingConstants.LEFT);
        port.setFont(new Font("宋体", Font.PLAIN, 14));
        port.setBounds(544, 10, 103, 20);
        panel1.add(port);
    }

    private void initInnerView(JPanel panel1) {
        JLabel userNameLabel = new JLabel("用户名:");
        userNameLabel.setFont(new Font("宋体", Font.BOLD, 14));
        userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userNameLabel.setBounds(10, 12, 60, 20);
        panel1.add(userNameLabel);

        JLabel accountLabel = new JLabel("账号:");
        accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accountLabel.setFont(new Font("宋体", Font.BOLD, 14));
        accountLabel.setBounds(139, 12, 60, 20);
        panel1.add(accountLabel);

        JLabel ipLabel = new JLabel("Ip地址:");
        ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ipLabel.setFont(new Font("宋体", Font.BOLD, 14));
        ipLabel.setBounds(303, 12, 60, 20);
        panel1.add(ipLabel);

        JLabel portLabel = new JLabel("端口:");
        portLabel.setHorizontalAlignment(SwingConstants.CENTER);
        portLabel.setFont(new Font("宋体", Font.BOLD, 14));
        portLabel.setBounds(488, 10, 60, 20);
        panel1.add(portLabel);
    }


}
