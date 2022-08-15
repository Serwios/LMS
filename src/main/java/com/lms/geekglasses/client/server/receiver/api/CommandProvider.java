package com.lms.geekglasses.client.server.receiver.api;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class CommandProvider {
    public static final Set<BaseCommandClass> commands = new HashSet<>();

    public CommandProvider() {
        commands.add(new PcDataCommand());
        commands.add(new SomeDataCommand());
        commands.add(new SomeDataCommand());
        commands.add(new DieCommand());
        commands.add(new HelpCommand());
        commands.add(new MenuCommand());
    }

    public Set<BaseCommandClass> getCommands() {
        return commands;
    }
}
