package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.IOException;

public class DieCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() throws IOException {
        throw new Error();
    }

    @Override
    public String getCommandName() {
        return "/die";
    }
}
