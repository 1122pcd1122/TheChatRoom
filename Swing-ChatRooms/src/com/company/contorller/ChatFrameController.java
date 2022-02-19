package com.company.contorller;


import com.company.server.Server;
import com.company.server.UserClient;
import com.company.utils.UserInfoUtil;
import com.company.views.ChatFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author peichendong
 */
public class ChatFrameController   {
    private final UserClient userClient;

    private final ChatFrame chatFrame;
    private static Server server;


    public static void getChatFrameController() {
        new ChatFrameController();
    }

    public ChatFrameController() {
        this.chatFrame = new ChatFrame();
        new ServerThread(chatFrame).start();
        userClient = new UserClient();
        chatFrame.sendBtn.addActionListener(new SendInfoToServer());
    }

    static class ServerThread extends Thread{

        private final ChatFrame chatFrame;

        public ServerThread(ChatFrame chatFrame) {
            this.chatFrame = chatFrame;
        }

        @Override
        public void run() {
            server = new Server(chatFrame);
        }
    }

    class SendInfoToServer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String text = chatFrame.sendTeArea.getText();
            chatFrame.receiveArea.append(UserInfoUtil.getUser().getNickName() +"说:");
            chatFrame.receiveArea.append(text+"\n");
            userClient.setSendInfo(text);
            try {
                userClient.sendInfo();
            } catch (IOException ioException) {
                System.out.println("传送出现问题");
            }
            UserClient.GetInfoThread getInfoThread = userClient.new GetInfoThread();
            getInfoThread.start();

        }
    }

    public static void main(String[] args) {
        getChatFrameController();
    }
}
