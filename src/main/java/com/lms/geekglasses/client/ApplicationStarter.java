package com.lms.geekglasses.client;

import com.lms.geekglasses.client.sender.MessageSender;
import com.lms.geekglasses.client.server.Server;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStarter {
    public static void main(String[] args) throws IOException {
        System.out.println("Application started > ");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Server());
        executorService.execute(new MessageSender());
    }
}
