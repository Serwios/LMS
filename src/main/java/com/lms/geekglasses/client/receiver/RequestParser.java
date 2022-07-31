package com.lms.geekglasses.client.receiver;

import com.lms.geekglasses.client.model.ReceiverOutputData;
import com.lms.geekglasses.client.receiver.api.BaseCommandClass;
import com.lms.geekglasses.client.receiver.api.PcDataCommand;
import com.lms.geekglasses.client.receiver.api.RunCmdCommand;
import com.lms.geekglasses.client.receiver.api.SomeDataCommand;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequestParser {
    private Set<BaseCommandClass> commands = new HashSet<>();

    public RequestParser() {
        this.commands.add(new PcDataCommand());
        this.commands.add(new SomeDataCommand());
        this.commands.add(new RunCmdCommand());
        this.commands.add(new SomeDataCommand());
    }

    public void parse(String msg) throws IOException {
        msg = msg.trim();

        for (BaseCommandClass bc : commands) {
            if (bc.getCommandName().equals(msg)) {
                ReceiverOutputData receiverOutputData = bc.performCommand();
                sendMassageBack(receiverOutputData);

                sendMassageBack("Success! Please, enter request");
                return;
            }
        }

        System.out.println("\nSorry, I didn`t recoginse msg: " + msg);
    }

    public void sendMassageBack(ReceiverOutputData receiverOutputData) {
        sendData(receiverOutputData.outputMassage);
    }

    public void sendMassageBack(String msg) {
        sendData(msg);
    }

    private void sendData(String data)  {
        try {
            try(Socket socket = new Socket("192.168.0.105", 8199);
                OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(data.getBytes());
                outputStream.flush();
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
