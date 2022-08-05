package com.lms.geekglasses.client.server;

import com.lms.geekglasses.client.server.receiver.ReceiverProcessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final int PORT = 8199;
    private final ReceiverProcessor receiverProcessor = new ReceiverProcessor();

    @Override
    public void run() {
        try {
            startServer(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServer(int port) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final Socket accept = serverSocket.accept();
                final PrintWriter output = new PrintWriter(accept.getOutputStream(),true);
                output.println(receiverProcessor.processRequestAndSendBackResponse(accept));
            }
        }
    }
}
