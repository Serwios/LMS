package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;

//TODO: Make this command to system instead to other receiver
public class HelpCommand implements BaseCommandClass{
    private final CommandProvider commandProvider = new CommandProvider();

    @Override
    public ReceiverTransferData performCommand() {
        return new ReceiverTransferData(CommandStatus.SUCCESS, commandProvider.toString());
    }

    @Override
    public String getCommandName() {
        return "/help";
    }
}
