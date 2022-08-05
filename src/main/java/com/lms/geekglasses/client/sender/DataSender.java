package com.lms.geekglasses.client.sender;

import com.lms.geekglasses.client.model.TransferData;

import java.io.OutputStream;
import java.net.Socket;

public class DataSender {
    public void sendData(TransferData data, String ip, int port)  {
        try {
            try(Socket socket = new Socket(prepareRawIp(ip), port);
                OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(data.getMassage().getBytes());
                outputStream.flush();
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    private String prepareRawIp(String ip) {
        if (null == ip) {
            throw new IllegalArgumentException("Failed to validate ip, ip is null");
        } else {
            return ip.replace("/", "").trim();
        }
    }
}
