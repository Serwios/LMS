package com.lms.geekglasses.client.receiver;

import com.lms.geekglasses.client.receiver.api.BaseCommandClass;
import com.lms.geekglasses.client.receiver.api.PcDataCommand;
import com.lms.geekglasses.client.receiver.api.RunCmdCommand;
import com.lms.geekglasses.client.receiver.api.SomeDataCommand;

import java.io.IOException;
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
                bc.performCommand();
                System.out.println("\nSuccess! Please, enter request");
                return;
            }
        }

        System.out.println("\nSorry, I didn`t recoginse msg: " + msg);
    }
}
