package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class AerialVehicle {
    private double weight;
    private double takeOfWeight;
    private String manufacturer;
    private int maxSpeed;
    public abstract int getMaxFlyingDistance();
    public abstract double getMaxDeliveryWeight();
}
