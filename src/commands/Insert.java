package commands;

import exceptions.EmptyFieldException;
import exceptions.IncorrectScriptInputException;
import exceptions.InvalidObjectException;
import exceptions.WrongArgsAmount;
import managers.CollectionManager;
import managers.Console;
import collections.HumanBeing;
import collections.Askers.HumanBeingAsker;

/**
 * Command that inserts element in the collection
 */
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
        return "insert";
    }

    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        try{
            if (args.length == 0){
                throw new WrongArgsAmount();
            }
            int key = Integer.parseInt(args[0]);
            if (collectionManager.getHumanBeingCollection().containsKey(key)){
                console.println("Element with this key already exists.");
                return false;
            }
            HumanBeing humanBeing = null;
            try {
                humanBeing = new HumanBeingAsker(console, collectionManager).build();
            } catch (IncorrectScriptInputException e) {
                throw new RuntimeException(e);
            } catch (EmptyFieldException e) {
                throw new RuntimeException(e);
            } catch (InvalidObjectException e) {
                throw new RuntimeException(e);
            }
            humanBeing.setId(key);
            console.println(humanBeing);
            collectionManager.insert(key, humanBeing);

            console.println("Element added successfully.");
            return true;

        } catch (WrongArgsAmount e){
            console.println("Wrong amount of arguments.");
        }
        return false;
    }
}
