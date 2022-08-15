package com.lms.geekglasses.client.server.receiver;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;
import com.lms.geekglasses.client.server.receiver.api.BaseCommandClass;
import com.lms.geekglasses.client.server.receiver.api.CommandProviderUtility;

import java.io.IOException;

public class RequestParser {
    public ReceiverTransferData parseRequest(String msg) throws IOException {
        for (BaseCommandClass bc : CommandProviderUtility.commands) {
            if (bc.getCommandName().equals(msg.trim())) {
               return bc.performCommand();
            }
        }

        return new ReceiverTransferData(CommandStatus.FAILED, "Sorry, I didn`t recoginse msg: " + msg);
    }
}
