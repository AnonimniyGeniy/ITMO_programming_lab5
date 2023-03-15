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
 * command for replacing value by key if new value is lower
 */
public class ReplaceIfLowe extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final Console console;
    private final CommandReceiver commandReceiver;

    public ReplaceIfLowe(Console console, CollectionManager collectionManager, CommandReceiver commandReceiver) {
        super("replace_if_lowe", "replace value by key if new value is lower");
        this.collectionManager = collectionManager;
        this.console = console;
        this.commandReceiver = commandReceiver;
    }


    @Override
    public boolean execute(String[] args) throws WrongArgsAmount {
        return commandReceiver.replaceIfLowe(args);
    }

}
