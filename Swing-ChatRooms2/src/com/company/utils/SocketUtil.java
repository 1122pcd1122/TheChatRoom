package com.company.utils;

import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUtil {
    public static DatagramSocket datagramSocket;

    public static DatagramSocket getDatagramSocket() {
        if (datagramSocket == null){
            try {
                datagramSocket = new DatagramSocket(5022);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        return datagramSocket;
    }
}
