package commands;

import managers.CollectionManager;
import managers.Console;

public class Insert extends AbstractCommand{

    private final Console console;
    private final CollectionManager collectionManager;

    public Insert(Console console, CollectionManager collectionManager){
        super("Insert", "Add element to the collection.");
        this.collectionManager = collectionManager;
        this.console = console;
    }
    @Override
    public String describe() {
        return "Inserts element in the collection.";
    }

    @Override
    public String getName() {
        return "Insert";
    }

    @Override
    public boolean execute(String[] args) {

        return false;
    }
}
