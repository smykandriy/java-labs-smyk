package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ToString(callSuper = true)
public class Helicopter extends AerialVehicle {
    private int id;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int fuelPerHour;
    private int currentFuel;
    public Helicopter() {
        this.id = 100;
        this.model = "Hip";
        this.maxAltitude = 5000;
        this.currentAltitude = 700;
        this.fuelCapacity = 1300;
        this.fuelPerHour = 330;
        this.currentFuel = 770;
        super.setManufacturer("Mi");
        super.setWeight(7000);
    }
    private static Helicopter defaultHelicopter = new Helicopter();

    public static Helicopter getInstance() {
        return defaultHelicopter;
    }

    public void takeOff() {
        this.currentAltitude += 100;
    }

    public void ascend(int altitude) {
        if (this.currentAltitude + altitude <= this.maxAltitude) {
            this.currentAltitude += altitude;
        } else {
            this.currentAltitude = this.maxAltitude;
        }
    }

    public void descend(int altitude) {
        if (altitude > this.currentAltitude) {
            this.currentAltitude = 0;
        } else {
            this.currentAltitude -= altitude;
        }
    }
    public void refuel(int fuel) {
        int fuelToMax = this.fuelCapacity - this.currentFuel;
        if (fuel > fuelToMax) {
            this.currentFuel = this.fuelCapacity;
            System.out.println("The fuel tank is full");
        } else {
            this.currentFuel += fuel;
        }
    }
    @Override
    public int getMaxFlyingDistance() {
        int flightTime = this.fuelCapacity / this.fuelPerHour;
        return this.getMaxSpeed() * flightTime;
    }
    @Override
    public double getMaxDeliveryWeight() {
        return this.getTakeOfWeight() - this.getWeight();
    }
}
