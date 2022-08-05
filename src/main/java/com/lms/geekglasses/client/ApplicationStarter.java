package com.lms.geekglasses.client;

import com.lms.geekglasses.client.sender.MessageSender;
import com.lms.geekglasses.client.server.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStarter {
    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        System.out.println("Application started > ");

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Server());
        executorService.execute(new MessageSender());
    }
}
