package com.company.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author peichendong
 */
public class RegisterFrame extends JFrame {
    public JTextField nickNameTextFiled;
    public JTextField passWordTextFiled;
    public JTextField confirmPassWordTextFiled;
    public JTextField emailTextFiled;
    public JTextField phoneTextFiled;
    public final JCheckBox checkCheckBox;
    public final JButton registerButton;
    public final ButtonGroup buttonGroup;
    public final JRadioButton boy;
    public final JRadioButton girl;


    public static void main(String[] args) {
        new RegisterFrame();
    }

    /**
     * Create the frame.
     */
    public RegisterFrame() {
        setBounds(100, 100, 569, 525);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nickNameTextFiled = new JTextField();
        nickNameTextFiled.setHorizontalAlignment(SwingConstants.LEFT);
        nickNameTextFiled.setToolTipText("");
        nickNameTextFiled.setBounds(169, 141, 273, 39);
        contentPane.add(nickNameTextFiled);
        nickNameTextFiled.setColumns(10);

        passWordTextFiled = new JTextField();
        passWordTextFiled.setToolTipText("");
        passWordTextFiled.setHorizontalAlignment(SwingConstants.LEFT);
        passWordTextFiled.setColumns(10);
        passWordTextFiled.setBounds(169, 190, 273, 39);
        contentPane.add(passWordTextFiled);

        JLabel welcomeLabel1 = new JLabel("欢迎注册QQ");
        welcomeLabel1.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 24));
        welcomeLabel1.setBounds(61, 21, 232, 53);
        contentPane.add(welcomeLabel1);

        JLabel welcomeLabel2 = new JLabel("每一天,乐在沟通");
        welcomeLabel2.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 18));
        welcomeLabel2.setBounds(30, 84, 222, 39);
        contentPane.add(welcomeLabel2);

        confirmPassWordTextFiled = new JTextField();
        confirmPassWordTextFiled.setToolTipText("");
        confirmPassWordTextFiled.setHorizontalAlignment(SwingConstants.LEFT);
        confirmPassWordTextFiled.setColumns(10);
        confirmPassWordTextFiled.setBounds(169, 288, 273, 39);
        contentPane.add(confirmPassWordTextFiled);

        emailTextFiled = new JTextField();
        emailTextFiled.setToolTipText("");
        emailTextFiled.setHorizontalAlignment(SwingConstants.LEFT);
        emailTextFiled.setColumns(10);
        emailTextFiled.setBounds(169, 337, 273, 39);
        contentPane.add(emailTextFiled);

        checkCheckBox = new JCheckBox("我已阅读并同意相关服务条款和隐私政策");
        checkCheckBox.setBounds(-1, 459, 253, 23);
        contentPane.add(checkCheckBox);

        registerButton = new JButton("立即注册");

        registerButton.setBounds(203, 414, 163, 39);
        contentPane.add(registerButton);

        JLabel nickName = new JLabel("昵称:");
        nickName.setFont(new Font("宋体", Font.BOLD, 14));
        nickName.setHorizontalAlignment(SwingConstants.CENTER);
        nickName.setBounds(80, 141, 79, 39);
        contentPane.add(nickName);

        JLabel passWord = new JLabel("密码:");
        passWord.setHorizontalAlignment(SwingConstants.CENTER);
        passWord.setFont(new Font("宋体", Font.BOLD, 14));
        passWord.setBounds(80, 190, 79, 39);
        contentPane.add(passWord);

        JLabel confirmPassWord = new JLabel("确认密码:");
        confirmPassWord.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPassWord.setFont(new Font("宋体", Font.BOLD, 14));
        confirmPassWord.setBounds(80, 288, 79, 39);
        contentPane.add(confirmPassWord);

        JLabel email = new JLabel("邮箱:");
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setFont(new Font("宋体", Font.BOLD, 14));
        email.setBounds(80, 337, 79, 39);
        contentPane.add(email);

        phoneTextFiled = new JTextField();
        phoneTextFiled.setToolTipText("");
        phoneTextFiled.setHorizontalAlignment(SwingConstants.LEFT);
        phoneTextFiled.setColumns(10);
        phoneTextFiled.setBounds(169, 239, 273, 39);
        contentPane.add(phoneTextFiled);

        buttonGroup = new ButtonGroup();

        JLabel phone = new JLabel("手机号:");
        phone.setHorizontalAlignment(SwingConstants.CENTER);
        phone.setFont(new Font("宋体", Font.BOLD, 14));
        phone.setBounds(80, 239, 79, 39);
        contentPane.add(phone);

        boy = new JRadioButton("男");
        boy.setBounds(169, 385, 52, 23);
        contentPane.add(boy);

        girl = new JRadioButton("女");
        girl.setBounds(223, 385, 52, 23);
        contentPane.add(girl);

        buttonGroup.add(boy);
        buttonGroup.add(girl);

        JLabel gender = new JLabel("性别:");
        gender.setHorizontalAlignment(SwingConstants.CENTER);
        gender.setFont(new Font("宋体", Font.BOLD, 14));
        gender.setBounds(80, 377, 79, 39);
        contentPane.add(gender);

        setVisible(true);
    }

    /**
     * 提示信息框
     */
    public void proInfoString (String info){
        JOptionPane.showMessageDialog(this,info,"注册失败",JOptionPane.WARNING_MESSAGE);
    }
}
