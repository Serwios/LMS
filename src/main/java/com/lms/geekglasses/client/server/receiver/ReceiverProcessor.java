package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverTransferData;
import com.lms.geekglasses.client.sender.DataSender;

import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.getPerformedCommandData;

public class ReceiverProcessor {
    private final DataSender dataSender = new DataSender();

    public void processRequestAndSendBackResponse(Socket connection, int port) {
        final String senderIp = connection.getInetAddress().getHostName();
        final ReceiverTransferData performedCommandOutputData = getPerformedCommandData(connection);

        dataSender.sendData(performedCommandOutputData, senderIp, port);
    }
}