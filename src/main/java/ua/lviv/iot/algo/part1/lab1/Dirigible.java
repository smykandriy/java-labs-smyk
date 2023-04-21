package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class Dirigible extends AerialVehicle {
    private int fuelCapacity;
    private int fuelPerHour;
    public final static String HEADERS = ", fuelCapacity, fuelPerHour";

    public Dirigible(double weight, double takeOfWeight,
                     String manufacturer, int maxSpeed,
                     int fuelCapacity, int fuelPerHour) {
        super(weight, takeOfWeight, manufacturer, maxSpeed);
        this.fuelCapacity = fuelCapacity;
        this.fuelPerHour = fuelPerHour;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + HEADERS;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + fuelCapacity + ", " + fuelPerHour;
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

