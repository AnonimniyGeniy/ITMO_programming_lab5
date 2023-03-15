package commands;


import managers.Console;

/**
 * Command to execute script from file
 */
public class ExecuteScript extends AbstractCommand {
    private final Console console;
    private final CommandReceiver commandReceiver;
    public ExecuteScript(Console console, CommandReceiver commandReceiver) {
        super("execute_script", "Execute script from file");
        this.console = console;
        this.commandReceiver = commandReceiver;
    }

    @Override
    public boolean execute(String[] args) {
        return commandReceiver.executeScript(args);
    }
}
