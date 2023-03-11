package commands;


import collections.Askers.HumanBeingAsker;
import collections.HumanBeing;
import exceptions.EmptyFieldException;
import exceptions.IncorrectScriptInputException;
import exceptions.InvalidObjectException;
import exceptions.WrongArgsAmount;
import managers.CollectionManager;
import managers.Console;

/**
 * command to update element by id
 */
public class Update extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final Console console;

    public Update(Console console, CollectionManager collectionManager) {
        super("update", "update element by id");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        try {
            if (args.length == 0) {
                throw new WrongArgsAmount();
            }
            int key = Integer.parseInt(args[0]);
            if (!collectionManager.getHumanBeingCollection().containsKey(key)) {
                console.println("Element with this key doesn't exist.");
                return false;
            }
            HumanBeing humanBeing = null;
            try {
                humanBeing = new HumanBeingAsker(console, collectionManager).build();
            } catch (IncorrectScriptInputException e) {
                console.println("Incorrect input.");
            } catch (EmptyFieldException e) {
                console.println("Field can't be empty.");
            } catch (InvalidObjectException e) {
                console.println("Invalid object.");
            }
            humanBeing.setId(key);
            console.println(humanBeing);
            collectionManager.removeById(key);
            collectionManager.insert(key, humanBeing);

            console.println("Element updated successfully.");
            return true;

        } catch (WrongArgsAmount e) {
            console.println("Wrong amount of arguments.");
        }
        return false;
    }

}
