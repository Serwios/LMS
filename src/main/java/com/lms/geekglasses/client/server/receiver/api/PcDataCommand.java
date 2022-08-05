package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverTransferData;
import oshi.SystemInfo;

public class PcDataCommand implements BaseCommandClass {
    @Override
    public ReceiverTransferData performCommand() {
        return new ReceiverTransferData(CommandStatus.SUCCESS, new SystemInfo().getHardware().getProcessor().toString());
    }

    @Override
    public String getCommandName() {
        return "/getPcData";
    }
}

