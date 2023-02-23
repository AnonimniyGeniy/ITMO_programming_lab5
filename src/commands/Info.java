package commands;
import aggregators.CollectionAggregator;

public class Info extends AbstractCommand{

    private final CollectionAggregator collectionAggregator;

    public Info(CollectionAggregator collectionAggregator){
        super("info","Get info about collection.");
        this.collectionAggregator = collectionAggregator;
    }
    @Override
    public String describe() {
        return "Выводит в консоль информацию о хранимой коллекции";
    }

    @Override
    public String getName() {
        return "Info";
    }

    @Override
    public boolean execute(String[] args) {
        
        return false;
    }
}
