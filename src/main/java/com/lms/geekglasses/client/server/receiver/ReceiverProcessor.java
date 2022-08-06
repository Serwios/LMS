package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.sender.DataSender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.handle;

public class ReceiverProcessor {
    private final DataSender dataSender = new DataSender();

    public void processRequestAndSendBackResponse(ServerSocket serverConnection, int port) throws IOException {
        dataSender.sendData(handle(serverConnection.accept()), serverConnection.getInetAddress().getHostName(), port);
    }
}
