package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.IOException;

public class TestCommand implements BaseCommandClass {
    @Override
    public ReceiverTransferData performCommand() throws IOException {
        return new ReceiverTransferData(CommandStatus.SUCCESS, "Success!");
    }

    @Override
    public String getCommandName() {
        return "/test";
    }
}
