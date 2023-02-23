package managers;

import commands.AbstractCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that manages commands.....
 */
public class CommandManager {
    private final Map<String, AbstractCommand> commands = new HashMap<>();
    private final List<String> commandHistory = new ArrayList<>();


    /**
     * Adds command to commands
     *
     * @param command - command(extends AbstractCommand)
     */
    public void addCommand(AbstractCommand command) {
        commands.put(command.getName(), command);
    }

    /**
     * getter for command history
     *
     * @return commandHistory
     */
    public List<String> getCommandHistory() {
        return commandHistory;
    }

    /**
     * getter for commands
     *
     * @return map with commands
     */
    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * method to write history of commands
     *
     * @param command name of command
     */
    public void addHistory(String command) {
        commandHistory.add(command);
    }
}
