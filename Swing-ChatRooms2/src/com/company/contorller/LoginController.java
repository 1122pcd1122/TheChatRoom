package com.company.contorller;

import com.company.server.LoginServerImpl;
import com.company.server.server.LoginServer;
import com.company.views.LoginFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author peichendong
 */
public class LoginController {




    private final LoginFrame loginFrame;
    private final LoginServer loginServer;


    public static void getLoginController(){
        new LoginController();
    }


    public LoginController() {
        this.loginFrame = new LoginFrame();
        this.loginServer = new LoginServerImpl();
        loginFrame.loginButton.addActionListener(new LoginListener());
        loginFrame.findPassWordLabel.addMouseListener(new FindPassWordListener());
        loginFrame.registerLabel.addMouseListener(new RegisterListener());
    }


    /**-
     * 登录监听器
     */
    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取登录信息
            String account = loginFrame.accountFiled.getText();
            String passWord = String.valueOf(loginFrame.passWordFiled.getPassword());

            //开始登录
            boolean b = loginServer.loginIng(account, passWord);
            if (b){
               MainFrameController.getMainFrameController();
            }else {
                //登录失败
                loginFrame.proInfo("登录失败","密码/用户名错误");
            }

        }
    }


    /**
     * 找回密码监听器
     */
    static class FindPassWordListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            //进入找回密码页
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    /**
     *注册监听器
     */
    static class RegisterListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            RegisterController.getRegisterController();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
