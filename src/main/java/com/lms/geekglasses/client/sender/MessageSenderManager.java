package com.lms.geekglasses.client.sender;

import com.lms.geekglasses.client.model.RequestTransferData;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.*;

public class MessageSenderManager implements Runnable {
    private static String IP = "localhost";
    private static final int PORT = 8199;

    private final Scanner globalScanner = new Scanner(System.in);
    private final NetworkIdentifier networkIdentifier = new NetworkIdentifier();
    private final DataSender dataSender = new DataSender();

    private List<String> availableIps;

    @SneakyThrows
    @Override
    public void run() {
        //TODO: change to final
        String selectedReceiverIp = null;

        availableIps = identifyNetwork();
        if (!availableIps.isEmpty()) {
            selectedReceiverIp = selectReceiver();
        } else {
            System.out.println("Please make a request > ");
        }

        inputSender(selectedReceiverIp, PORT);
    }

    public String selectReceiver() {
        while (true) {
            System.out.println("Please, enter receiver ip: ");
            Scanner scanner = new Scanner(System.in);
            String ip = scanner.nextLine();
            if (availableIps.contains(ip)) {
                IP = ip.replace("/", "");
                return IP;
            } else {
                System.out.println("Sorry, I don`t see this ip");
            }
        }
    }

    public List<String> identifyNetwork() throws IOException {
        return networkIdentifier.identifyNearbyDevices();
    }

    public void inputSender(String ip, int port) {
        while (true) {
            final String data = globalScanner.nextLine();
            dataSender.sendData(new RequestTransferData(data), ip, port);
        }
    }
}
