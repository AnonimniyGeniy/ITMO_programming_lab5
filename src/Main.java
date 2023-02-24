import commands.AbstractCommand;
import commands.Info;
import commands.Insert;
import managers.CollectionManager;
import managers.CommandManager;
import managers.UserConsole;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        List<AbstractCommand> commands = new ArrayList<>();
        var console = new UserConsole();
        commands.add(new Info(console, collectionManager));
        commands.add(new Info(console, collectionManager));

        var commandManager = new CommandManager(commands);


    }
}