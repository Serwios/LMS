package com.lms.geekglasses.client.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class RequestTransferData implements TransferData {
    public String message;

    @Override
    public String getMassage() {
        return message;
    }
}
