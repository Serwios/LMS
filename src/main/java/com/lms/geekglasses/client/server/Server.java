package com.lms.geekglasses.client.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.lms.geekglasses.client.receiver.RequestHandler.handle;

public class Server implements Runnable {
    private final int PORT = 8199;

    @Override
    public void run() {
        try {
            startServer(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startServer(int port) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final Socket accept = serverSocket.accept();
                handle(accept);
            }
        }
    }
}
