package managers;

import commands.Command;

import java.util.Scanner;

/**
 * Class that controls the command input mode and manages Scanner and handling whole execution.
 */
public class Executor {


    private final CommandManager commandManager;
    private final Console Console;

    /**
     * enum for status of execution
     */
    public enum Status {
        OK,
        ERROR,
        EXIT,
    }

    /**
     * constructor for Executor
     *
     * @param commandManager - CommandManager
     *                       for managing commands
     *                       and command history
     * @param Console        - console for user interaction
     */
    public Executor(CommandManager commandManager, Console Console) {
        this.commandManager = commandManager;
        this.Console = Console;
    }

    /**
     * method for executing commands in console mode
     */
    public void consoleMode() {
        Scanner userScanner = CommandParser.getScanner();
        try{
            Status status;
            String[] command;
            do {
                Console.print("Enter command: ");
                command = userScanner.nextLine().trim().split(" ", 2);
                status = executeCommand(command);
            } while (status != Status.EXIT);
        } catch (Exception e) {
            Console.println("Error: " + e.getMessage());
        }
    }


    /**
     * method for executing commands in script mode
     *
     * @param userCommand - command to execute
     * @return status of execution
     */
    private Status executeCommand(String[] userCommand){
        if (userCommand.length == 0) {
            return Status.OK;
        }
        Command command = commandManager.getCommands().get(userCommand[0]);
        if (command == null) {
            Console.println("Unknown command");
            return Status.ERROR;
        }
        try {
            if (userCommand[0].equals("exit")) {
                return Status.EXIT;
            }
            if (userCommand.length == 1) {
                command.execute(new String[0]);
                commandManager.addHistory(userCommand[0]);
            } else{
                command.execute(userCommand[1].trim().split(" "));
                commandManager.addHistory(userCommand[0]);
            }
            return Status.OK;
        } catch (Exception e) {
            Console.println("Error: " + e.getMessage());
            return Status.ERROR;
        }
    }



}
