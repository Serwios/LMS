package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.sender.DataSender;

import java.io.IOException;
import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.getPerformedCommandData;

public class ReceiverProcessor {
    private final DataSender dataSender = new DataSender();

    public void processRequestAndSendBackResponse(Socket connection, int port) throws IOException {
        String ip = connection.getInetAddress().getHostName();
        dataSender.sendData(getPerformedCommandData(connection), ip, port);
    }
}