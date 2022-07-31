package com.lms.geekglasses.client.sender;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkResolver {
    private final String subNet = "192.168.0";

    public List<String> resolveAvailableComputersIps() throws IOException {
        List<String> listOfIps = new ArrayList<>();
        System.out.println("Please wait, I try to resolve nearby computers");

        final int timeout = 100;
        for (int i = 1; i < 255; i++) {
            String host = subNet + "." + i;
            InetAddress inetAddress = InetAddress.getByName(host);

            if (inetAddress.isReachable(timeout)) {
                listOfIps.add(inetAddress.toString());
            }
        }

        if (listOfIps.isEmpty()) {
            System.out.println("There is no available computers in network");
        }

        return listOfIps;
    }

    public String getCurrentIpAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        } catch (Throwable e) {
            System.out.println("Failed to get local machine address" + e);
            return "";
        }
    }
}
