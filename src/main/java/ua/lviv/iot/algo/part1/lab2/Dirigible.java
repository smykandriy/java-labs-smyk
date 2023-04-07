package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Dirigible extends AerialVehicle {
    private int fuelCapacity;
    private int fuelPerHour;

    public Dirigible(double weight, double takeOfWeight,
                     String manufacturer, int maxSpeed,
                     int fuelCapacity, int fuelPerHour) {
        super(weight, takeOfWeight, manufacturer, maxSpeed);
        this.fuelCapacity = fuelCapacity;
        this.fuelPerHour = fuelPerHour;
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
