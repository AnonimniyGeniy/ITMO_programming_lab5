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
 * command for replacing value by key if new value is lower
 */
public class Replace_if_lowe extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final Console console;

    public Replace_if_lowe(Console console, CollectionManager collectionManager) {
        super("replace_if_lowe", "replace value by key if new value is lower");
        this.collectionManager = collectionManager;
        this.console = console;
    }


    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        try {
            if (args.length != 1) {
                throw new WrongArgsAmount();
            }
            int key = Integer.parseInt(args[0]);
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
            if (collectionManager.getHumanBeingCollection().get(key).compareTo(humanBeing) > 0) {
                collectionManager.insert(key, humanBeing);
                console.println("Element changed successfully.");
            }


            return true;

        } catch (WrongArgsAmount e) {
            console.println("Wrong amount of arguments.");
        }
        return false;
    }

}
