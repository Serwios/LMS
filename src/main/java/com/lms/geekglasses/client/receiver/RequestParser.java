package com.lms.geekglasses.client.receiver;

import com.lms.geekglasses.client.model.ReceiverOutputData;
import com.lms.geekglasses.client.receiver.api.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequestParser {
    private final CommandProvider commands = new CommandProvider();

    public void parse(String msg) throws IOException {
        msg = msg.trim();

        for (BaseCommandClass bc : commands.getCommands()) {
            if (bc.getCommandName().equals(msg)) {
                ReceiverOutputData receiverOutputData = bc.performCommand();
                return;
            }
        }

        System.out.println("\nSorry, I didn`t recoginse msg: " + msg);
    }
}
