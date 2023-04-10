package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AerialVehicleManagerTest {
    AerialVehicleManager aerialVehicleManager = new AerialVehicleManager();

    @BeforeEach
    public void setUp() {
        aerialVehicleManager.addAerialVehicle(new Helicopter(7000, 13000,
                "Mi", 70,
                101, "Hip",
                2000, 3800,
                2000, 200,
                800));
        aerialVehicleManager.addAerialVehicle(new Drone(10, 25,
                "DeViro", 70,
                300, 3));
        aerialVehicleManager.addAerialVehicle(new Dirigible(70000, 130000,
                "Zeppelin", 200,
                13000, 130));
        aerialVehicleManager.addAerialVehicle(new Plane(90000, 120000,
                "Boeing", 460,
                35000, 3500));
    }

    @Test
    @DisplayName("Testing add method")
    public void testAddAerialVehicle() {
        assertEquals(4, aerialVehicleManager.getAircraftsList().size());
    }

    @Test
    @DisplayName("Testing findAllHeavierThan method")
    void findAllHeavierThan() {
        List<AerialVehicle> heavyAerialVehiclesFromManager = aerialVehicleManager.findAllHeavierThan(50000);
        List<AerialVehicle> heavyAerialVehicles = new LinkedList<>();
        heavyAerialVehicles.add(new Dirigible(70000, 130000,
                "Zeppelin", 200,
                13000, 130));
        heavyAerialVehicles.add(new Plane(90000, 120000,
                "Boeing", 460,
                35000, 3500));
        assertFalse(heavyAerialVehiclesFromManager.isEmpty());
        assertEquals(heavyAerialVehicles.toString(), heavyAerialVehiclesFromManager.toString());
    }

    @Test
    @DisplayName("Testing findAllByManufacturer method")
    void findAllByManufacturer() {
        List<AerialVehicle> deviroDronesFromManager = aerialVehicleManager.findAllByManufacturer("DeViro");
        List<AerialVehicle> deviroDrones = new LinkedList<>();
        deviroDrones.add(new Drone(10, 25,
                "DeViro", 70,
                300, 3));
        assertFalse(deviroDronesFromManager.isEmpty());
        assertEquals(deviroDrones.toString(), deviroDronesFromManager.toString());
    }
}