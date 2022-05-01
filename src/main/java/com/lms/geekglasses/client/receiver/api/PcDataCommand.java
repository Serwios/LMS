package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.CommandStatus;
import com.lms.geekglasses.client.model.ReceiverOutputData;
import oshi.SystemInfo;

public class PcDataCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() {
        ReceiverOutputData receiverOutputData = new ReceiverOutputData(CommandStatus.SUCCESS, new SystemInfo().getHardware().getProcessor().toString());
        System.out.println(receiverOutputData);

        return receiverOutputData;
    }

    @Override
    public String getCommandName() {
        return "/getPcData";
    }
}
