package commands;


/**
 * Command for exit from program
 * @author AnonimniyGeniy
 */
public class Exit extends AbstractCommand{

    public Exit(){
        super("Exit", "Stop the program.");
    }

    /**
     * Execute command
     *
     * @param args
     * @return Execution result
     */
    @Override
    public boolean execute(String[] args) {
        //if len of args > 0 print error in console by user console
        //else exit
        if (args.length > 0) {
            return false;
        } else {
            System.exit(0);
            return true;
        }
    }
}
