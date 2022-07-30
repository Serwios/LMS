package com.lms.geekglasses.client.model;

import lombok.ToString;

@ToString
public class ReceiverOutputData {
    public CommandStatus status;
    public String outputMassage;

    public ReceiverOutputData(CommandStatus status, String outputMassage) {
        this.status = status;
        this.outputMassage = outputMassage;
    }
}
