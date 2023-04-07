package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AerialVehicleManager {
    private List<AerialVehicle> aircraftsList = new LinkedList<>();
    public void addAerialVehicle(final AerialVehicle aircraft){
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

    public static void main(String[] args) {

        var aircraftsList = new AerialVehicleManager();

        for (int i = 0; i < 2; i++) {
            aircraftsList.addAerialVehicle(new Helicopter(7000, 13000,
                    "Mi", 70,
                    101, "Hip",
                    2000, 3800,
                    2000, 200,
                    800));
            aircraftsList.addAerialVehicle(new Drone(10, 25,
                    "DeViro", 70,
                    300, 3));
            aircraftsList.addAerialVehicle(new Dirigible(70000, 130000,
                    "Zeppelin", 200,
                    13000, 130));
            aircraftsList.addAerialVehicle(new Plane(90000, 120000,
                    "Boeing", 460,
                    35000, 3500));
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
