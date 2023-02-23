package commands;

import aggregators.CollectionAggregator;

public class Insert extends AbstractCommand{

    private final CollectionAggregator collectionAggregator;

    public Insert(CollectionAggregator collectionAggregator){
        super("Insert", "Add element to the collection.");
        this.collectionAggregator = collectionAggregator;
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
