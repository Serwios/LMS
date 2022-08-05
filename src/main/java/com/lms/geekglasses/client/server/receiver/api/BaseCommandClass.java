package com.lms.geekglasses.client.server.receiver.api;

import com.lms.geekglasses.client.model.ReceiverTransferData;

import java.io.IOException;

public interface BaseCommandClass extends CommandIdentyfier {
    ReceiverTransferData performCommand() throws IOException;
}
