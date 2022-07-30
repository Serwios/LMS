package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.IOException;

public interface BaseCommandClass extends CommandIdentyfier {
    ReceiverOutputData performCommand() throws IOException;
}
