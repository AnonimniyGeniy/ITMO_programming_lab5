package commands;


import collections.Askers.CarAsker;
import collections.Car;
import collections.HumanBeing;
import exceptions.EmptyFieldException;
import exceptions.IncorrectScriptInputException;
import managers.CollectionManager;
import managers.Console;

/**
 * show all elements whose car field value is greater than the specified one
 */
public class Count_greater_than_car extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final Console console;
    public Count_greater_than_car(Console console, CollectionManager collectionManager) {
        super("count_greater_than_car", "show all elements whose car field value is greater than the specified one");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String[] args) {
        try{
            if (args.length != 0){
                console.println("Command doesn't need any arguments");
                return false;
            }
            int count = 0;
            Car car = new CarAsker(console).askCar();
            for (HumanBeing humanBeing : collectionManager.getHumanBeingCollection().values()){
                if (humanBeing.getCar().compareTo(car) > 0) count++;
            }
            console.println("There are " + count + " elements whose car field value is greater than the specified one");
            return true;
        } catch (EmptyFieldException e) {
            console.println("Field can't be empty.");
        } catch (IncorrectScriptInputException e) {
            console.println("Incorrect input.");
        }
        return false;
    }


}
