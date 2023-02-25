import collections.Askers.CarAsker;
import collections.Askers.CoordinatesAsker;
import collections.Askers.HumanBeingAsker;
import collections.Askers.WeaponTypeAsker;
import collections.Car;
import collections.Coordinates;
import collections.WeaponType;
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
        commandParser.setScanner(new Scanner(System.in));

        try {
            //W car = new CarAsker(console).build();

            Double minutesOfWaiting = new HumanBeingAsker(console, collectionManager).askMinuteOfWaiting();
            System.out.println(minutesOfWaiting);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}