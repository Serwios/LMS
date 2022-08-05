package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.ReceiverTransferData;
import com.lms.geekglasses.client.server.receiver.api.BaseCommandClass;
import com.lms.geekglasses.client.server.receiver.api.CommandProvider;

import java.io.IOException;

public class RequestParser {
    private final CommandProvider commands = new CommandProvider();

    public ReceiverTransferData parseRequest(String msg) throws IOException {
        msg = msg.trim();

        for (BaseCommandClass bc : commands.getCommands()) {
            if (bc.getCommandName().equals(msg)) {
               return bc.performCommand();
            }
        }

        System.out.println("\nSorry, I didn`t recoginse msg: " + msg);
        return null;
    }
}
