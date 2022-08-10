package com.lms.geekglasses.client.sender;

import com.lms.geekglasses.client.model.RequestTransferData;
import com.lms.geekglasses.client.server.menu.Menu;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Scanner;

public class MessageSenderManager implements Runnable {
    private final int PORT = 8199;

    private final Scanner globalScanner = new Scanner(System.in);
    private final NetworkIdentifier networkIdentifier = new NetworkIdentifier();
    private final DataSender dataSender = new DataSender();

    //TODO: make cache
    private List<String> availableIps;

    @SneakyThrows
    @Override
    public void run() {
        availableIps = identifyNetwork();
        final String selectedReceiverIp = selectReceiverIp();

        System.out.println(new Menu(availableIps, InetAddress.getLocalHost().getHostName()));
        readAndSendInputToReceiver(selectedReceiverIp, PORT);
    }

    private String selectReceiverIp() {
        if (!availableIps.isEmpty()) {
            return getReceiverIpFromInput();
        } else {
            return "localhost";
        }
    }

    public List<String> identifyNetwork() throws IOException {
        return networkIdentifier.identifyNearbyDevices();
    }

    public String getReceiverIpFromInput() {
        while (true) {
            System.out.println("Please, enter receiver ip: ");
            Scanner scanner = new Scanner(System.in);
            String ip = scanner.nextLine();
            if (availableIps.contains(ip)) {
                return ip.replace("/", "");
            } else {
                System.out.println("Sorry, I don`t see this ip. Type menu or help");
            }
        }
    }

    public void readAndSendInputToReceiver(String ip, int port) {
        while (true) {
            final String data = globalScanner.nextLine();
            dataSender.sendData(new RequestTransferData(data), ip, port);
        }
    }
}
