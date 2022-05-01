package com.lms.geekglasses.client.model;

public class ReceiverOutputData {
    public CommandStatus status;
    public String outputMassage;

    public ReceiverOutputData(CommandStatus status, String outputMassage) {
        this.status = status;
        this.outputMassage = outputMassage;
    }

    @Override
    public String toString() {
        return "ReceiverOutputData{" +
                "status=" + status +
                ", outputMassage='" + outputMassage + '\'' +
                '}';
    }
}
