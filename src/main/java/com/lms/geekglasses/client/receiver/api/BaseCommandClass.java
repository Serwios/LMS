package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.ReceiverOutputData;

public interface BaseCommandClass extends CommandIdentyfier {
    ReceiverOutputData performCommand();
}
