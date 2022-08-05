package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.IOException;

public class RunCmdCommand implements BaseCommandClass {
    @Override
    public ReceiverTransferData performCommand() throws IOException {
        System.out.println("Not implemented");

        return null;
    }

    @Override
    public String getCommandName() {
        return "/getCmd";
    }
}
