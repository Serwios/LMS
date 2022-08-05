package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.IOException;

public class DieCommand implements BaseCommandClass {
    @Override
    public ReceiverTransferData performCommand() throws IOException {
        throw new Error();
    }

    @Override
    public String getCommandName() {
        return "/die";
    }
}
