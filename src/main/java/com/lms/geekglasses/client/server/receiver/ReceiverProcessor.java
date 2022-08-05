package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverTransferData;
import com.lms.geekglasses.client.sender.DataSender;

import java.io.IOException;
import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.handle;

public class ReceiverProcessor {
    private final DataSender dataSender = new DataSender();

    public void processRequestAndSendBackResponse(Socket requestConnection, int port) throws IOException {
        ReceiverTransferData receiverTransferData = handle(requestConnection);
        requestConnection.close();

        dataSender.sendData(receiverTransferData, requestConnection.getInetAddress().getHostName(), port);
    }
}
