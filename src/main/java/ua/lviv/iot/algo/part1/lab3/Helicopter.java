package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class Helicopter extends AerialVehicle {
    private int id;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int fuelPerHour;
    private int currentFuel;

    public Helicopter(double weight, double takeOfWeight,
                      String manufacturer, int maxSpeed,
                      int id, String model, int currentAltitude,
                      int maxAltitude, int fuelCapacity,
                      int fuelPerHour, int currentFuel) {
        super(weight, takeOfWeight, manufacturer, maxSpeed);
        this.id = id;
        this.model = model;
        this.currentAltitude = currentAltitude;
        this.maxAltitude = maxAltitude;
        this.fuelCapacity = fuelCapacity;
        this.fuelPerHour = fuelPerHour;
        this.currentFuel = currentFuel;
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
