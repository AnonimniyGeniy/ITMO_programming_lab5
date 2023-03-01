import commands.AbstractCommand;
import commands.*;
import managers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        List<AbstractCommand> commands = new ArrayList<>();
        var console = new UserConsole();
        commands.add(new Info(console, collectionManager));
        commands.add(new Insert(console, collectionManager));
        commands.add(new Exit(console, collectionManager));

        var commandManager = new CommandManager(commands);
        commandManager.addCommand(new History(console, commandManager));

        CommandParser commandParser = new CommandParser();
        CommandParser.setScanner(new Scanner(System.in));

        try {
            /*
            collectionManager.setHumanBeingCollection(new TreeMap<>());
            commandManager.getCommands().get("exit").execute(CommandParser.getScanner().nextLine().split(" "));
            */
            collectionManager.setHumanBeingCollection(new TreeMap<>());
            Executor executor = new Executor(commandManager, console);
            executor.consoleMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}