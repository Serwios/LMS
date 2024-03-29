package com.lms.geekglasses.client.sender;

import com.lms.geekglasses.client.model.TransferData;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class DataSender {
    public void sendData(TransferData data, String ip, int port) {
        if (data == null) {
            System.out.println("Data is null, cannot send.");
            return;
        }
        
        try {
            String formattedIp = prepareRawIp(ip);
            try (Socket socket = new Socket(formattedIp, port);
                 OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(data.getMessage().getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            System.err.println("Failed to send data: " + e.getMessage());
        }
    }

    private String prepareRawIp(String ip) {
        if (ip == null) {
            throw new IllegalArgumentException("IP address cannot be null.");
        }
        return ip.replace("/", "").trim();
    }
}
