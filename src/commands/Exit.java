package commands;


import managers.CollectionManager;
import managers.Console;

/**
 * Command for exit from program
 * @author AnonimniyGeniy
 */
public class Exit extends AbstractCommand{
    private final Console console;
    private final CollectionManager collectionManager;
    public Exit(Console console, CollectionManager collectionManager){

        super("exit", "Stop the program.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Execute command
     *
     * @param args
     * @return Execution result
     */
    @Override
    public boolean execute(String[] args) {
        //if len of args > 0 print error in console by user console
        //else exit
        if (args.length > 0) {
            return false;
        } else {
            console.println("Saving collection to file...");
            System.exit(0);
            return true;
        }
    }
}
