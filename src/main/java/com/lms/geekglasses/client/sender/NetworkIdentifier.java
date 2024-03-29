package com.lms.geekglasses.client.sender;

import java.io.IOException;
import java.util.List;

public class NetworkIdentifier {
    private final NetworkResolver networkResolver = new NetworkResolver();

    public List<String> identifyNearbyDevices() throws IOException {
        List<String> resolvedIps = networkResolver.resolveAvailableComputersIps();
        String currentIpAddress = networkResolver.getCurrentIpAddress();

        System.out.println("Welcome: " + currentIpAddress);
        if (resolvedIps.isEmpty()) {
            System.out.println("No available IP addresses; receiver set to localhost.");
        } else {
            System.out.println("Available IP addresses: " + resolvedIps);
        }

        return resolvedIps;
    }
}
