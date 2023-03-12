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
 * command for removing all elements from collection that are greater than the specified one
 */

public class Remove_greater extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final Console console;

    public Remove_greater(Console console, CollectionManager collectionManager) {
        super("remove_greater", "remove all elements from collection that are greater than the specified one");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        try{
            if (args.length != 0){
                throw new WrongArgsAmount();
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

            collectionManager.removeGreater(humanBeing);
            console.println(humanBeing);



        } catch (WrongArgsAmount e){
            console.println("Wrong amount of arguments.");
        }
        return false;
    }


}
