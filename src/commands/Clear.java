package commands;

import managers.CollectionManager;
import managers.Console;

import java.util.TreeMap;


/**
 * command for clearing collection
 */
public class Clear extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final Console console;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "clear collection");
        this.collectionManager = collectionManager;
        this.console = console;
    }


    @Override
    public boolean execute(String[] args) {
        collectionManager.setHumanBeingCollection(new TreeMap<>());
        console.println("Collection was cleared");
        return true;
    }
}
