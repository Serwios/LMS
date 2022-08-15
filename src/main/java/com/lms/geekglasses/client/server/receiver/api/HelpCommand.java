package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.util.Arrays;

//TODO: Make this command to system instead to other receiver
public class HelpCommand implements BaseCommandClass{
    @Override
    public ReceiverTransferData performCommand() {
        final CommandProvider commandProvider = new CommandProvider();
        return new ReceiverTransferData(CommandStatus.SUCCESS, commandProvider.getCommands().toString());
    }

    @Override
    public String getCommandName() {
        return "/help";
    }
}
