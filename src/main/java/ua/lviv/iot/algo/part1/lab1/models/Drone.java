package ua.lviv.iot.algo.part1.lab1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
@Getter
public class Drone extends AerialVehicle {
    private int batteryCapacity;
    private int batteryChargePerMinute;
    public final static String HEADERS = ", batteryCapacity, batteryChargePerMinute";

    public Drone(double weight, double takeOfWeight,
                 String manufacturer, int maxSpeed,
                 int batteryCapacity, int batteryChargePerMinute) {
        super(weight, takeOfWeight, manufacturer, maxSpeed);
        this.batteryCapacity = batteryCapacity;
        this.batteryChargePerMinute = batteryChargePerMinute;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + HEADERS;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + batteryCapacity + ", " + batteryChargePerMinute;
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
