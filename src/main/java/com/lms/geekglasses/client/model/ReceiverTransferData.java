package com.lms.geekglasses.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class ReceiverTransferData implements TransferData {
    public CommandStatus status;
    public String message;

    @Override
    public String getMassage() {
        return message;
    }
}
