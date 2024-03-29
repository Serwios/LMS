package com.lms.geekglasses.client.sender;

import com.lms.geekglasses.client.model.RequestTransferData;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MessageSenderManager implements Runnable {
    private static final String DEFAULT_IP = "localhost";
    private static final int DEFAULT_PORT = 8199;

    private final Scanner scanner = new Scanner(System.in);
    private final NetworkIdentifier networkIdentifier = new NetworkIdentifier();
    private final DataSender dataSender = new DataSender();

    private List<String> availableIps;

    @SneakyThrows
    @Override
    public void run() {
        String selectedReceiverIp = null;
        availableIps = identifyNetwork();

        if (!availableIps.isEmpty()) {
            selectedReceiverIp = selectReceiver();
        } else {
            System.out.println("Please make a request > ");
        }

        inputSender(selectedReceiverIp, DEFAULT_PORT);
    }

    public String selectReceiver() {
        while (true) {
            System.out.println("Please enter receiver IP: ");
            String ip = scanner.nextLine();
            if (availableIps.contains(ip)) {
                return ip.replace("/", "");
            } else {
                System.out.println("Sorry, this IP is not available.");
            }
        }
    }

    public List<String> identifyNetwork() throws IOException {
        return networkIdentifier.identifyNearbyDevices();
    }

    public void inputSender(String ip, int port) {
        while (true) {
            System.out.println("Enter data to send: ");
            String data = scanner.nextLine();
            dataSender.sendData(new RequestTransferData(data), ip, port);
        }
    }
}
