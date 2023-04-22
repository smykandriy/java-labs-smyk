package ua.lviv.iot.algo.part1.lab1.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.models.Drone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroneTest {
    Drone drone;
    Drone droneNull = new Drone();

    @BeforeEach
    public void setUp() {
         drone = new Drone(10, 25,
                "DeViro", 70,
                300, 3);
    }

    @Test
    public void testGetMaxFlyingDistance() {
        int flightTime = drone.getBatteryCapacity() / drone.getBatteryChargePerMinute();
        int maxFlyingDistance = drone.getMaxSpeed() * flightTime;
        assertEquals(maxFlyingDistance, drone.getMaxFlyingDistance());
    }

    @Test
    public void testGetMaxDeliveryWeight() {
        double maxDeliveryWeight = drone.getTakeOfWeight() - drone.getWeight();
        assertEquals(maxDeliveryWeight, drone.getMaxDeliveryWeight());
    }
}