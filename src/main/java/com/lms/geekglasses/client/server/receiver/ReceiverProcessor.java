package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.IOException;
import java.net.Socket;

import static com.lms.geekglasses.client.server.receiver.RequestHandler.handle;

public class ReceiverProcessor {
    public ReceiverOutputData processRequestAndSendBackResponse(Socket accept) throws IOException {
        return handle(accept);
    }
}
