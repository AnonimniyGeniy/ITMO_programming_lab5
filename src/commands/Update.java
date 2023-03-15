package commands;


import collections.HumanBeing;
import collections.askers.HumanBeingAsker;
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
    private final CommandReceiver commandReceiver;
    public Update(Console console, CollectionManager collectionManager, CommandReceiver commandReceiver) {
        super("update", "update element by id");
        this.collectionManager = collectionManager;
        this.console = console;
        this.commandReceiver = commandReceiver;
    }

    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        return commandReceiver.update(args);
    }

}
