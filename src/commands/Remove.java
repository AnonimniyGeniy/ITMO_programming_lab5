package commands;


import exceptions.WrongArgsAmount;
import managers.CollectionManager;
import managers.Console;

/**
 * command for removing element from collection by id
 */
public class Remove extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final Console console;

    public Remove(Console console, CollectionManager collectionManager) {
        super("remove", "remove element from collection by id");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) {
        try {
            if (args.length != 1) {
                throw new WrongArgsAmount();
            }
            int id = Integer.parseInt(args[0]);
            if (collectionManager.removeById(id)) {
                console.println("Element with id " + id + " was removed");
                return true;
            } else {
                console.println("Element with id " + id + " was not found");
                return false;
            }
        } catch (NumberFormatException e) {
            console.println("Id must be integer");

        } catch (WrongArgsAmount wrongArgsAmount) {
            console.println("Wrong amount of arguments");
        }
        return false;
    }
}
