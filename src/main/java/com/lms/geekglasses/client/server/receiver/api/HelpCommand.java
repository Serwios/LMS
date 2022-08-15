package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;

public class HelpCommand implements BaseCommandClass{
    @Override
    public ReceiverTransferData performCommand() {
        return new ReceiverTransferData(CommandStatus.SUCCESS, CommandProvider.getCommandsAsString());
    }

    @Override
    public String getCommandName() {
        return "/help";
    }
}
