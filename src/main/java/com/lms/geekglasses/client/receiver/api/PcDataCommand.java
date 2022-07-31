package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverOutputData;
import oshi.SystemInfo;

public class PcDataCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() {
        return new ReceiverOutputData(CommandStatus.SUCCESS, new SystemInfo().getHardware().getProcessor().toString());
    }

    @Override
    public String getCommandName() {
        return "/getPcData";
    }
}

