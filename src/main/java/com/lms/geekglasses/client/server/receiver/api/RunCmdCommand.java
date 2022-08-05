package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.IOException;

public class RunCmdCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() throws IOException {
        System.out.println("Not implemented");

        return null;
    }

    @Override
    public String getCommandName() {
        return "/getCmd";
    }
}
