package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverOutputData;
import oshi.SystemInfo;

public class SomeDataCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() {
        final String computerSystem = new SystemInfo().getHardware().getComputerSystem().toString();
        return new ReceiverOutputData(CommandStatus.SUCCESS, computerSystem);
    }

    @Override
    public String getCommandName() {
        return "/getOS";
    }
}
