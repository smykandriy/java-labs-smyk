package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
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
        List<AerialVehicle> aircraftsArray = new ArrayList<>();
        aircraftsArray.add(new Helicopter());
        aircraftsArray.add(new Drone());
        aircraftsArray.add(new Dirigible());
        aircraftsArray.add(new Plane());

        System.out.println("All objects:");
        for (AerialVehicle aircraft : aircraftsArray) {
            System.out.println(aircraft);
        }

        var aircraftsList = new AerialVehicleManager();
        aircraftsList.addAerialVehicles(aircraftsArray);
        aircraftsList.addAerialVehicles(aircraftsArray);

        aircraftsList.getAircraftsList().get(0).setManufacturer("Mi");
        aircraftsList.getAircraftsList().get(1).setManufacturer("DeViro");
        aircraftsList.getAircraftsList().get(2).setManufacturer("Zeppelin");
        aircraftsList.getAircraftsList().get(3).setManufacturer("Boeing");
        aircraftsList.getAircraftsList().get(5).setManufacturer("DeViro");

        var deviroDrones = aircraftsList.findAllByManufacturer("DeViro");

        System.out.println("The manufacturer of these drones is DeViro:");
        for (AerialVehicle drone : deviroDrones) {
            System.out.println(drone);
        }

        aircraftsList.getAircraftsList().get(0).setWeight(7000);
        aircraftsList.getAircraftsList().get(1).setWeight(5);
        aircraftsList.getAircraftsList().get(2).setWeight(350000);
        aircraftsList.getAircraftsList().get(3).setWeight(70000);

        var aircrafts = aircraftsList.findAllHeavierThan(10000);

        System.out.println("These objects are heavier than 10000kg:");
        for (AerialVehicle aircraft : aircrafts) {
            System.out.println(aircraft);
        }
    }
}
