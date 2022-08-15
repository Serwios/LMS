package com.lms.geekglasses.client.server.receiver.api;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CommandProvider {
    private final Set<BaseCommandClass> commands = new HashSet<>();

    public CommandProvider() {
        this.commands.add(new PcDataCommand());
        this.commands.add(new SomeDataCommand());
        this.commands.add(new RunCmdCommand());
        this.commands.add(new SomeDataCommand());
        this.commands.add(new DieCommand());
    }
}
