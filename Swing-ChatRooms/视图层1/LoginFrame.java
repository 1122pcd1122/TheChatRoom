package com.company.views;

import javax.swing.*;
import java.awt.*;

/**
 * @author peichendong
 */
public class LoginFrame extends JFrame {


    private final JPanel contentPane;
    public JTextField accountFiled;

    public JPasswordField passWordFiled;

    /**
     * 头像
     */
    public JLabel headPhoto;

    /**
     * 账号label
     */
    public JLabel accountLabel;
    /**
     * 密码label
     */
    public JLabel passWordLabel;
    /**
     * 登录按钮
     */
    public JButton loginButton;
    /**
     *
     * 注册label
     */
    public JLabel registerLabel;
    /**
     * 自动登录
     */
    public JCheckBox autoLoginCheckBox;
    /**
     * 记住密码
     */
    public JCheckBox remPassWordCheckBox;
    /**
     * 找回密码
     */
    public JLabel findPassWordLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new LoginFrame();
    }

    /**
     * Create the frame.
     */
    public LoginFrame() {
        setBounds(100, 100, 570, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initView();


        setVisible(true);

    }

    private void initView() {
        int width = 80;
        int height = 80;
        headPhoto = new JLabel();
        headPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon image = new ImageIcon("C:\\Users\\peichendong\\Pictures\\icon.jpg");
        image.setImage(image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
        headPhoto.setIcon(image);
        headPhoto.setBounds(226, 46, 80, 80);
        contentPane.add(headPhoto);

        accountFiled = new JTextField();
        accountFiled.setBounds(214, 152, 175, 30);
        contentPane.add(accountFiled);
        accountFiled.setColumns(10);

        passWordFiled = new JPasswordField();
        passWordFiled.setBounds(214, 211, 175, 30);
        contentPane.add(passWordFiled);
        passWordFiled.setColumns(10);

        accountLabel = new JLabel("账号:");
        accountLabel.setFont(new Font("幼圆", Font.BOLD, 15));
        accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accountLabel.setBounds(135, 151, 70, 30);
        contentPane.add(accountLabel);

        passWordLabel = new JLabel("密码:");
        passWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passWordLabel.setFont(new Font("幼圆", Font.BOLD, 15));
        passWordLabel.setBounds(135, 211, 70, 30);
        contentPane.add(passWordLabel);

        loginButton = new JButton("登录");

        loginButton.setBounds(163, 286, 226, 39);
        contentPane.add(loginButton);

        registerLabel = new JLabel("注册账号");
        registerLabel.setFont(new Font("宋体", Font.BOLD, 14));
        registerLabel.setForeground(Color.GRAY);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(10, 305, 80, 30);
        contentPane.add(registerLabel);

        autoLoginCheckBox = new JCheckBox("自动登录");
        autoLoginCheckBox.setFont(new Font("宋体", Font.PLAIN, 12));
        autoLoginCheckBox.setBounds(163, 255, 80, 25);
        contentPane.add(autoLoginCheckBox);

        remPassWordCheckBox = new JCheckBox("记住密码");
        remPassWordCheckBox.setFont(new Font("宋体", Font.PLAIN, 12));
        remPassWordCheckBox.setBounds(248, 255, 80, 25);
        contentPane.add(remPassWordCheckBox);

        findPassWordLabel = new JLabel("找回密码");
        findPassWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        findPassWordLabel.setForeground(Color.BLACK);
        findPassWordLabel.setFont(new Font("宋体", Font.PLAIN, 12));
        findPassWordLabel.setBounds(327, 255, 80, 25);
        contentPane.add(findPassWordLabel);
    }

    /**
     * 提示信息框
     */
    public void proInfo(String infoTitle,String info){
        JOptionPane.showMessageDialog(this,info,infoTitle,JOptionPane.WARNING_MESSAGE);
    }

}
