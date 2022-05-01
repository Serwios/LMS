package com.lms.geekglasses.client.receiver;

import com.lms.geekglasses.client.receiver.api.BaseCommandClass;
import com.lms.geekglasses.client.receiver.api.PcDataCommand;

import java.util.ArrayList;
import java.util.List;

public class RequestParser {
    private List<BaseCommandClass> commands = new ArrayList<>();

    public RequestParser() {
        this.commands.add(new PcDataCommand());
    }

    public void parse(String msg) {
        for (BaseCommandClass bc : commands) {
            if (bc.getCommandName().equals(msg)) {
                bc.performCommand();
            }
        }
    }
}
