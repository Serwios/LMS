package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.sender.DataSender;

import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.handle;

public class ReceiverProcessor {
    private final DataSender dataSender = new DataSender();

    public void processRequestAndSendBackResponse(Socket accept) {
        dataSender.sendData(handle(accept), "", 0);
    }
}
