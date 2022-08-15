package com.lms.geekglasses.client.server.receiver.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandProviderUtility {
    public static final HashSet<BaseCommandClass> commands = new HashSet<>(
            Arrays.asList(
                new PcDataCommand(),
                new SomeDataCommand(),
                new SomeDataCommand(),
                new DieCommand(),
                new HelpCommand(),
                new MenuCommand()
            )
    );

    public static String getCommandsAsString() {
        return Arrays.toString(commands.toArray());
    }
}
