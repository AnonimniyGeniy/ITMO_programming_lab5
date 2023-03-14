package commands;


import managers.CollectionManager;
import managers.Console;

/**
 * Command to execute script from file
 */
public class Execute_script extends AbstractCommand{
    private final Console console;

    public Execute_script(Console console) {
        super("execute_script", "Execute script from file");
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length == 0) {
            console.printErr("No file name specified, usage: execute_script <file_name>");
            return false;
        }
        if (args.length > 1) {
            console.printErr("Too many arguments, usage: execute_script <file_name>");
            return false;
        }
        String fileName = args[0];
        console.println("Executing script from file " + fileName);
        return true;
    }
}
