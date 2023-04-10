package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AerialVehicle {
    private double weight;
    private double takeOfWeight;
    private String manufacturer;
    private int maxSpeed;
    public abstract int getMaxFlyingDistance();
    public abstract double getMaxDeliveryWeight(); // abstract as task said
}
