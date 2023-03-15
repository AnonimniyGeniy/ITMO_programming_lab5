package commands;

import exceptions.WrongArgsAmount;
import managers.CollectionManager;
import managers.Console;

/**
 * Command that inserts element in the collection
 */
public class Insert extends AbstractCommand {

    private final Console console;
    private final CollectionManager collectionManager;
    private final CommandReceiver commandReceiver;

    public Insert(Console console, CollectionManager collectionManager, CommandReceiver commandReceiver) {
        super("Insert", "Add element to the collection.");
        this.collectionManager = collectionManager;
        this.console = console;
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String describe() {
        return "Inserts element in the collection.";
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        return commandReceiver.insert(args);
    }
}
