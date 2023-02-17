package collections;

import java.time.LocalDate;

public class HumanBeing {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private Boolean hasToothpick; //Поле может быть null
    private Integer impactSpeed; //Поле не может быть null
    private String soundtrackName; //Поле не может быть null
    private double minutesOfWaiting;
    private WeaponType weaponType; //Поле не может быть null
    private Car car; //Поле не может быть null


    public HumanBeing() {

    }

    public HumanBeing(Long id, String name, Coordinates coordinates, boolean realHero, Boolean hasToothpick, Integer impactSpeed, String soundtrackName, double minutesOfWaiting, WeaponType weaponType, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;
    }
}
