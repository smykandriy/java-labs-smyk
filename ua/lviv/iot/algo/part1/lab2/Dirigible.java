package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(callSuper = true)
public class Dirigible extends AerialVehicle{
    private int fuelCapacity;
    private int fuelPerHour;
    public Dirigible() {
        this.fuelCapacity = 30000;
        this.fuelPerHour = 600;
        super.setManufacturer("Zeppelin");
        super.setWeight(70000);
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

