package collections;

import commands.Command;
import other.Validatable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class HumanBeing implements Comparable<HumanBeing>, Validatable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private Boolean hasToothpick; //Поле может быть null
    private Float impactSpeed; //Поле не может быть null
    private String soundtrackName; //Поле не может быть null
    private Double minutesOfWaiting; //Поле может быть null
    private WeaponType weaponType; //Поле может быть null
    private Car car; //Поле может быть null


    public HumanBeing() {

    }

    public HumanBeing(String name, Coordinates coordinates, boolean realHero, Boolean hasToothpick, Float impactSpeed, String soundtrackName, Double minutesOfWaiting, WeaponType weaponType, Car car) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean validate() {
        return name != null && !name.equals("") && coordinates != null
                && creationDate != null && impactSpeed != null
                && soundtrackName != null;
    }

    /**
     * @param o the object to be compared.
     * @return comparison result
     */
    @Override
    public int compareTo(HumanBeing o) {
        if (impactSpeed < o.impactSpeed) {
            return -1;
        } else if (impactSpeed == o.impactSpeed) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * getter for ID of HumanBeing
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * toString method
     * @return string representation of HumanBeing
     */
    @Override
    public String toString(){
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Coordinates: " + coordinates.toString() + "\n" +
                "Creation date: " + creationDate + "\n" +
                "Real hero: " + realHero + "\n" +
                "Has toothpick: " + hasToothpick + "\n" +
                "Impact speed: " + impactSpeed + "\n" +
                "Soundtrack name: " + soundtrackName + "\n" +
                "Minutes of waiting: " + minutesOfWaiting + "\n" +
                "Weapon type: " + weaponType + "\n" +
                "Car: " + car.toString();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return creationDate
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * @return realHero
     */
    public boolean isRealHero() {
        return realHero;
    }

    /**
     * @return hasToothpick
     */
    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    /**
     * @return impactSpeed
     */
    public Float getImpactSpeed() {
        return impactSpeed;
    }

    /**
     * @return soundtrackName
     */
    public String getSoundtrackName() {
        return soundtrackName;
    }

    /**
     * @return minutesOfWaiting
     */
    public Double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    /**
     * @return weaponType
     */
    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     * @return car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param coordinates coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @param realHero realHero
     */
    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

}
