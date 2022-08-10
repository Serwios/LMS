package com.lms.geekglasses.client.server.menu;

import java.util.List;

public class Menu {
    private final List<String> availableIps;
    private final String hostIp;

    public Menu(List<String> availableIps, String hostIp) {
        this.availableIps = availableIps;
        this.hostIp = hostIp;
    }

    public String getMenu() {
        return "Menu:" + "\n"
                + "Available ip's: " + availableIps + "\n"
                + "Your ip : " + hostIp + "\n"
                + "Please enter a new command, or /help for list of all commands";
    }
}
