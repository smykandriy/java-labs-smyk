package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class AerialVehicleManager {
    private List<AerialVehicle> aircraftsList = new LinkedList<>();
    public void addAerialVehicle(final AerialVehicle aircraft){
        this.aircraftsList.add(aircraft);
    }
    public void addAerialVehicles(List<AerialVehicle> aircrafts){
        this.aircraftsList.addAll(aircrafts);
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
    public static void main(String[] args) {

        var aircraftsList = new AerialVehicleManager();

        for (int i = 0; i < 2; i++) {
            aircraftsList.addAerialVehicle(new Helicopter());
            aircraftsList.addAerialVehicle(new Drone());
            aircraftsList.addAerialVehicle(new Dirigible());
            aircraftsList.addAerialVehicle(new Plane());
        }

        System.out.println("All objects:");
        for (AerialVehicle aircraft : aircraftsList.getAircraftsList()) {
            System.out.println(aircraft);
        }

        var deviroDrones = aircraftsList.findAllByManufacturer("DeViro");

        System.out.println("\nThe manufacturer of these drones is DeViro:");
        for (AerialVehicle drone : deviroDrones) {
            System.out.println(drone);
        }

        var heavyAircrafts = aircraftsList.findAllHeavierThan(10000);

        System.out.println("These objects are heavier than 10000kg:");
        for (AerialVehicle aircraft : heavyAircrafts) {
            System.out.println(aircraft);
        }
    }
}
