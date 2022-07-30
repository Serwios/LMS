package com.lms.geekglasses.client.sender;

import java.io.IOException;
import java.util.List;

public class NetworkIdentifier {
    private final NetworkResolver networkResolver = new NetworkResolver();

    public List<String> identifyNearbyDevices() throws IOException {
        final List<String> resolvedIps = networkResolver.resolveAvailableComputersIps();

        System.out.println("Welcome: " + networkResolver.getCurrentIpAddress());
        if (resolvedIps.isEmpty()) {
            System.out.println("No available ip, receiver settled to @localhost");
        } else {
            System.out.println("Available ip`s: " + resolvedIps);
        }

        return resolvedIps;
    }
}
