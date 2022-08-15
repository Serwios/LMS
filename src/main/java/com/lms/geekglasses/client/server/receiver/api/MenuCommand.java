package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;
import com.lms.geekglasses.client.sender.MessageSenderManager;
import com.lms.geekglasses.client.server.menu.Menu;

import java.io.IOException;
import java.net.InetAddress;

public class MenuCommand implements BaseCommandClass {
    @Override
    public ReceiverTransferData performCommand() throws IOException {
        final MessageSenderManager messageSenderManager = new MessageSenderManager();
        final Menu menuCommand = new Menu(messageSenderManager.identifyNetwork(), InetAddress.getLocalHost().getHostAddress());
        return new ReceiverTransferData(CommandStatus.SUCCESS, menuCommand.getMenu());
    }

    @Override
    public String getCommandName() {
        return "/menu";
    }
}
