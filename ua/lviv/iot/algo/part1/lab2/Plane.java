package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(callSuper = true)
public class Plane extends AerialVehicle{
    private int fuelCapacity;
    private int fuelPerHour;
    public Plane() {
        this.fuelCapacity = 48000;
        this.fuelPerHour = 2500;
        super.setManufacturer("Boeing");
        super.setWeight(350000);
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
