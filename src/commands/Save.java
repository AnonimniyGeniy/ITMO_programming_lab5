package commands;


import managers.CollectionManager;
import managers.Console;

/**
 * comamnd that saves collection to file
 */
public class Save extends AbstractCommand {
    private final Console console;
    private final CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "Save collection to file.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            console.printErr("The command doesn't take any arguments, usage: save");
            return false;
        }
        collectionManager.saveCollection();
        return true;
    }

}
