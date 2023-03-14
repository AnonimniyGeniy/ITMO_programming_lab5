package managers;

import commands.Command;
import exceptions.RecursionInScriptRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that controls the command input mode and manages Scanner and handling whole execution.
 */
public class Executor {

    private final List<String> recursionStack = new ArrayList<>();
    private final CommandManager commandManager;
    private final Console console;

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
        this.console = Console;
    }

    /**
     * method for executing commands in console mode
     */
    public void consoleMode() {
        Scanner userScanner = CommandParser.getScanner();
        try {
            Status status;
            String[] command;
            do {
                console.print("Enter command: ");
                command = userScanner.nextLine().trim().split(" ", 2);
                status = executeCommand(command);
            } while (status != Status.EXIT);
        } catch (Exception e) {
            console.println("Error in console mode");
        }
    }


    /**
     * method for executing commands in script mode
     *
     * @param args - arguments of command
     * @return status of execution
     */

    public Status scriptMode(String arg) {
        String[] command = new String[2];
        Status status;
        recursionStack.add(arg);
        if (!new File(arg).exists()) {
            arg = "../" + arg;
        }
        Scanner defaultScanner = CommandParser.getScanner();
        try (Scanner scanner = new Scanner(new File(arg))) {
            if (!scanner.hasNextLine()) {
                console.println("File is empty");
                return Status.ERROR;
            }

            CommandParser.setScanner(scanner);
            CommandParser.setFileMode();
            //do while loop for executing commands from file
            do {
                command = scanner.nextLine().trim().split(" ", 2);
                while (scanner.hasNextLine() && command[0].isEmpty()) {
                    command = scanner.nextLine().trim().split(" ", 2);
                }
                console.println("Executing command: " + command[0]);

                if (command[0].equals("execute_script")) {
                    for (String s : recursionStack) {
                        if (s.equals(command[1])) throw new RecursionInScriptRecursion();
                    }
                }
                status = executeCommand(command);


            } while (status == Status.OK && scanner.hasNextLine());

            CommandParser.setScanner(defaultScanner);
            CommandParser.setConsoleMode();
            if (status == Status.ERROR && !(command[0].equals("execute_script")) && !(command[1].isEmpty())) {
                console.println("Error in file " + arg);
            }
            return status;

        } catch (FileNotFoundException e) {
            console.println("File not found");
        } catch (RecursionInScriptRecursion e) {
            console.println("Recursion in script");
        }finally {
            CommandParser.setScanner(defaultScanner);
            CommandParser.setConsoleMode();
        }

        return Status.ERROR;
    }


    /**
     * method for executing commands in cli mode
     *
     * @param userCommand - command to execute
     * @return status of execution
     */
    private Status executeCommand(String[] userCommand) {
        if (userCommand.length == 0) {
            return Status.OK;
        }
        Command command = commandManager.getCommands().get(userCommand[0]);
        if (command == null) {
            console.println("Unknown command");
            return Status.ERROR;
        }
        try {
            if (userCommand[0].equals("exit")) {
                return Status.EXIT;
            } else if (userCommand[0].equals("execute_script")) {
                if (!commandManager.getCommands().get("execute_script").execute(userCommand[1].trim().split(" "))) return Status.ERROR;
                return scriptMode(userCommand[1]);
            }
            if (userCommand.length == 1) {
                command.execute(new String[0]);
                commandManager.addHistory(userCommand[0]);
            } else {
                command.execute(userCommand[1].trim().split(" "));
                commandManager.addHistory(userCommand[0]);
            }
            return Status.OK;
        } catch (Exception e) {
            console.println("Error: " + e.getMessage());
            return Status.ERROR;
        }
    }


}
