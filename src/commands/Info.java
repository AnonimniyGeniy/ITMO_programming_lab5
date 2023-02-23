package commands;
import managers.CollectionManager;

public class Info extends AbstractCommand{

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager){
        super("info","Get info about collection.");
        this.collectionManager = collectionManager;
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
