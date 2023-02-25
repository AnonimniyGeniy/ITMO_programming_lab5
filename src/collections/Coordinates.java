package collections;

import other.Validatable;

public class Coordinates implements Validatable {
    private double x; //Максимальное значение поля: 180
    private int y;

    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;

    }

    public boolean validate() {
        return x <= 180;
    }
}