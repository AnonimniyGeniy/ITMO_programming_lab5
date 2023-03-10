import commands.AbstractCommand;
import commands.*;
import managers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        var console = new UserConsole();
        String path = System.getenv("FILENAME");

        FileManager fileManager = new FileManager(path, console);
        CollectionManager collectionManager = new CollectionManager(console, fileManager);
        List<AbstractCommand> commands = new ArrayList<>();
        commands.add(new Info(console, collectionManager));
        commands.add(new Insert(console, collectionManager));
        commands.add(new Exit(console, collectionManager));
        commands.add(new Save(console, collectionManager));
        commands.add(new Show(console, collectionManager));
        commands.add(new Remove(console, collectionManager));
        commands.add(new Update(console, collectionManager));
        commands.add(new Clear(console, collectionManager));
        commands.add(new Remove_greater(console, collectionManager));
        commands.add(new Replace_if_lowe(console, collectionManager));
        commands.add(new Group_counting_by_impact(console, collectionManager));
        commands.add(new Count_greater_than_car(console, collectionManager));
        commands.add(new Print_descending(console, collectionManager));
        commands.add(new Execute_script(console));
        var commandManager = new CommandManager(commands);
        commandManager.addCommand(new History(console, commandManager));
        commandManager.addCommand(new Help(console, commandManager.getCommandsArray()));

        CommandParser commandParser = new CommandParser();
        CommandParser.setScanner(new Scanner(System.in));

        try {
            /*
            collectionManager.setHumanBeingCollection(new TreeMap<>());
            commandManager.getCommands().get("exit").execute(CommandParser.getScanner().nextLine().split(" "));
            */
            collectionManager.loadCollection();
            Executor executor = new Executor(commandManager, console);
            executor.consoleMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}