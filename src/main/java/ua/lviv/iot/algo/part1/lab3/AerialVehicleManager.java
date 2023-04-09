package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AerialVehicleManager {
    private List<AerialVehicle> aircraftsList = new LinkedList<>();

    public void addAerialVehicle(final AerialVehicle aircraft) {
        this.aircraftsList.add(aircraft);
    }

    public List<AerialVehicle> findAllHeavierThan(int weight) {
        return aircraftsList.stream().
                filter(craft -> craft.getWeight() > weight).
                collect(Collectors.toList());
    }

    public List<AerialVehicle> findAllByManufacturer(String manufacturer) {
        return aircraftsList.stream().
                filter(craft -> craft.getManufacturer().equals(manufacturer)).
                collect(Collectors.toList());
    }
}
