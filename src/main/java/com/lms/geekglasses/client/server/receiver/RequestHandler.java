package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RequestHandler {
    private static final RequestParser parser = new RequestParser();

    public static ReceiverTransferData getPerformedCommandData(Socket accept) {
        try(final InputStream inputStream = accept.getInputStream()) {
            final StringBuilder requestBuilder = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) requestBuilder.append((char) read);

            final String requestString = requestBuilder.toString();
            if (isRequestIsCommand(requestString)) return parser.parseRequest(requestString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static boolean isRequestIsCommand(String requestBody) {
        return requestBody.startsWith("/");
    }
}