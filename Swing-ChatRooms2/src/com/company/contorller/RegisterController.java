package com.company.contorller;


import com.company.server.RegisterServerImpl;
import com.company.server.server.RegisterServer;
import com.company.utils.FriendInfoUtil;
import com.company.views.RegisterFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author peichendong
 */
public class RegisterController {



    private final RegisterFrame registerFrame;
    private final RegisterServer registerServer;

    public static void getRegisterController(){
        new RegisterController();
    }

    public RegisterController() {
        registerFrame = new RegisterFrame();
        registerServer = new RegisterServerImpl();
        registerFrame.registerButton.addActionListener(new RegisterListener());
    }

    /**
     * 注册监听器
     */
    class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!registerFrame.passWordTextFiled.getText().equals(registerFrame.confirmPassWordTextFiled.getText())){
                //说明注册信息
                registerFrame.proInfoString("两次密码错误");
                return;
            }

            FriendInfoUtil.getUser().setNickName(registerFrame.nickNameTextFiled.getText());
            FriendInfoUtil.getUser().setPassWord(registerFrame.passWordTextFiled.getText());
            FriendInfoUtil.getUser().setPhoneNumber(registerFrame.phoneTextFiled.getText());
            if (registerFrame.buttonGroup.isSelected(registerFrame.boy.getModel())){
                FriendInfoUtil.getUser().setSex("男");
            }else {
                FriendInfoUtil.getUser().setSex("女");
            }
            FriendInfoUtil.getUser().setEmail(registerFrame.emailTextFiled.getText());

            boolean b = registerServer.registerIng(FriendInfoUtil.getUser());
            System.out.println(b);
            if (b){
                //说明注册信息
                registerFrame.proInfoString("注册成功");
            }else{
                //说明注册信息
                registerFrame.proInfoString("注册失败");
            }
        }
    }
}
