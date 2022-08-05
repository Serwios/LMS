package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Optional;

public class RequestHandler {
    private static final RequestParser parser = new RequestParser();

    public static ReceiverOutputData handle(Socket accept) throws IOException {
        try(final InputStream inputStream = accept.getInputStream()) {
            final StringBuilder requestBuilder = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) requestBuilder.append((char) read);

            return parser.parseRequest(requestBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ReceiverOutputData(CommandStatus.FAILED, "Failed tp parse msg");
    }
}
