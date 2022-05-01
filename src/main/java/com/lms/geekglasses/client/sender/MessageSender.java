package com.lms.geekglasses.client.sender;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender implements Runnable {
    private static final String IP = "localhost";
    private static final int PORT = 8199;
    private final Scanner globalScanner = new Scanner(System.in);

    public void inputReader() {
        while (true) {
            final String data = globalScanner.nextLine();
            sendData(data);
        }
    }

    private void sendData(String data)  {
        try {
            try(Socket socket = new Socket(IP, PORT);
                OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(data.getBytes());
                outputStream.flush();
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void run() {
        inputReader();
    }
}
