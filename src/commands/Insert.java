package commands;

import managers.CollectionManager;

public class Insert extends AbstractCommand{

    private final CollectionManager collectionManager;

    public Insert(CollectionManager collectionManager){
        super("Insert", "Add element to the collection.");
        this.collectionManager = collectionManager;
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
