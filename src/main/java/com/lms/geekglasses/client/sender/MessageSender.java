package com.lms.geekglasses.client.sender;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

public class MessageSender implements Runnable {
    private static String IP = "localhost";
    private static final int PORT = 8199;

    private final Scanner globalScanner = new Scanner(System.in);
    private final NetworkIdentifier networkIdentifier = new NetworkIdentifier();
    private List<String> availableIps = new ArrayList<>();

    @SneakyThrows
    @Override
    public void run() {
        availableIps = identifyNetwork();
        if (!availableIps.isEmpty()) {
            selectReceiver();
        } else {
            System.out.println("Please make a request > ");
        }

        inputReader();
    }

    public void selectReceiver() {
        while (true) {
            System.out.println("Please, enter receiver ip: ");
            Scanner scanner = new Scanner(System.in);
            String ip = scanner.nextLine();
            if (availableIps.contains(ip)) {
                IP = ip.replace("/", "");
                return;
            } else {
                System.out.println("Sorry, I don`t see this ip");
            }
        }
    }

    public List<String> identifyNetwork() throws IOException {
        return networkIdentifier.identifyNearbyDevices();
    }

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
}
