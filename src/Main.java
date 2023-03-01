import commands.AbstractCommand;
import commands.Info;
import commands.Insert;
import managers.CollectionManager;
import managers.CommandManager;
import managers.CommandParser;
import managers.UserConsole;

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

        var commandManager = new CommandManager(commands);
        //console.println(commandManager.getCommands());
        //commandManager.getCommands().get("info").execute(new String[0]);
        CommandParser commandParser = new CommandParser();
        CommandParser.setScanner(new Scanner(System.in));

        try {
            collectionManager.setHumanBeingCollection(new TreeMap<>());
            commandManager.getCommands().get("insert").execute(CommandParser.getScanner().nextLine().split(" "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}