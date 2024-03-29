package com.lms.geekglasses.client.sender;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkResolver {
    private static final String SUBNET = "192.168.0";

    public List<String> resolveAvailableComputersIps() {
        List<String> listOfIps = new ArrayList<>();
        System.out.println("Please wait, attempting to resolve nearby computers...");

        final int timeout = 100;
        for (int i = 1; i < 255; i++) {
            String host = SUBNET + "." + i;
            try {
                InetAddress inetAddress = InetAddress.getByName(host);
                if (inetAddress.isReachable(timeout)) {
                    listOfIps.add(inetAddress.getHostAddress());
                }
            } catch (IOException e) {
                // Handle or log any IOException that may occur during InetAddress resolution
                System.err.println("Error resolving IP address: " + e.getMessage());
            }
        }

        if (listOfIps.isEmpty()) {
            System.out.println("There are no available computers in the network.");
        }

        return listOfIps;
    }

    public String getCurrentIpAddress() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        } catch (IOException e) {
            // Handle or log any IOException that may occur during socket creation
            System.err.println("Failed to get local machine address: " + e.getMessage());
            return "";
        }
    }
}
