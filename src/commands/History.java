package commands;


import managers.CollectionManager;
import managers.CommandManager;
import managers.Console;

/**
 * Command that shows last 13 commands (without their arguments)
 */
public class History extends AbstractCommand {
    private final CommandManager commandManager;
    private final Console console;

    /**
     * Constructor for History
     */
    public History(Console console, CommandManager commandManager) {
        super("history", "Shows last 13 commands (without their arguments)");
        this.commandManager = commandManager;
        this.console = console;
    }


    /**
     * Description of command
     */
    @Override
    public String describe() {
        return "Show last 13 commands (without their arguments)";
    }

    /**
     * Name of command
     */
    @Override
    public String getName() {
        return "history";
    }

    /**
     * Method for executing this command
     */
    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            console.printErr("The command doesn't take any arguments, usage: history");
            return false;
        }
        console.println("Last 13 commands:");
        for (String command : commandManager.getCommandHistory()) {
            console.println(command);
        }
        return true;
    }
}
