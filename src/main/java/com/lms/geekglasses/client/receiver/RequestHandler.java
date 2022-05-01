package com.lms.geekglasses.client.receiver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RequestHandler {
    private static final RequestParser parser = new RequestParser();

    public static void handle(Socket accept) throws IOException {
        try(final InputStream inputStream = accept.getInputStream()) {
            final StringBuilder requestBuilder = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) requestBuilder.append((char) read);

            parser.parse(requestBuilder.toString());
        }
    }
}
