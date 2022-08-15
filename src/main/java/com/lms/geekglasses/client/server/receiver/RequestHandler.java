package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.InputStream;
import java.net.Socket;

public class RequestHandler {
    private static final RequestParser parser = new RequestParser();

    public static ReceiverTransferData getPerformedCommandData(Socket accept) {
        try(final InputStream inputStream = accept.getInputStream()) {
            final StringBuilder requestBuilder = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) requestBuilder.append((char) read);

            String requestBody = requestBuilder.toString();
            System.out.println(requestBody);
            if (requestBody.startsWith("/")) {
                return parser.parseRequest(requestBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}