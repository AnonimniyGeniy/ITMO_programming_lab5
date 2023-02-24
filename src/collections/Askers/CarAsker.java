package collections.Askers;

import exceptions.IncorrectScriptInputException;
import managers.CommandParser;
import managers.Console;
import collections.Car;
import exceptions.EmptyFieldException;
import exceptions.InvalidObjectException;


public class CarAsker extends Asker {

    private final Console console;


    public CarAsker(Console console) {
        this.console = console;
    }

    /**
     * @return
     */
    @Override
    public Car build() throws IncorrectScriptInputException, EmptyFieldException, InvalidObjectException {
        var car = askCar();
        if (!car.validate()) throw new InvalidObjectException();

        return car;
    }

    /**
     * @return Car object
     * @throws EmptyFieldException
     * @throws IncorrectScriptInputException
     */
    public Car askCar() throws EmptyFieldException, IncorrectScriptInputException {
        Car car;
        String name;
        var fileMode = CommandParser.fileMode();
        while (true) {
            try {
                console.println("Enter car name:");
                name = CommandParser.getScanner().nextLine().trim();
                if (name.equals("")) throw new EmptyFieldException();
                car = new Car(name);
                break;

            } catch (EmptyFieldException e) {
                console.println("Field can't be empty");
                if (fileMode) throw new IncorrectScriptInputException();
            }
        }
        return car;
    }


}


