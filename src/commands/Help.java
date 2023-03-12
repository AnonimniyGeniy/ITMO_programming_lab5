package commands;


import managers.Console;

/**
 * shows help for available commands
 */
public class Help extends AbstractCommand {
    private final AbstractCommand[] commands;
    private final Console console;

    public Help(Console console, AbstractCommand[] commands) {
        super("help", "shows help for available commands");
        this.commands = commands;
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) {
        try {
            if (args.length != 0) {
                console.println("Command doesn't take arguments");
                return false;
            }
            for (AbstractCommand command : commands) {
                console.println(command.getName() + " - " + command.describe());
            }
            console.println("help - " + describe());
            return true;
        } catch (Exception e) {
            console.println("Something went wrong");
            return false;
        }
    }
}
