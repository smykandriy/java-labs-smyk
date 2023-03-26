package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Drone extends AerialVehicle{
    private int batteryCapacity;
    private int batteryChargePerMinute;
    public Drone() {
        this.batteryCapacity = 300;
        this.batteryChargePerMinute = 3;
    }
    @Override
    public int getMaxFlyingDistance() {
        int flightTime = batteryCapacity / batteryChargePerMinute;
        return this.getMaxSpeed() * flightTime;
    }

    @Override
    public double getMaxDeliveryWeight() {
        return this.getTakeOfWeight() - this.getWeight();
    }
}
