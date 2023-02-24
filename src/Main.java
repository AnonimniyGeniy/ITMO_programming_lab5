import commands.AbstractCommand;
import commands.Info;
import commands.Insert;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        List<AbstractCommand> commands = new ArrayList<>();
        commands.add(new Info(collectionManager));
        commands.add(new Info(collectionManager));

        var commandManager = new CommandManager(commands);
        commandManager.getCommands().get("");
    }
}