package com.lms.geekglasses.client.receiver.api;

import com.lms.geekglasses.client.model.ReceiverOutputData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunCmdCommand implements BaseCommandClass {
    @Override
    public ReceiverOutputData performCommand() throws IOException {
        System.out.println("CMD was loaded");
        System.out.println("PS: If you want to finish execution. print 'bye'");

        String command;

        while (true) {
            command = new Scanner(System.in).nextLine();

            if (command.equals("bye")) {
                System.out.println("Bye!");
                return null;
            } else {
                if (command.equals("")) {
                    continue;
                }

                resolveCommandOutput(Runtime.getRuntime().exec(command));
            }
        }
    }

    private void resolveCommandOutput(Process proc) throws IOException {
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

        System.out.println("Output:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        System.out.println("\nError (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

    @Override
    public String getCommandName() {
        return "/getCmd";
    }
}
