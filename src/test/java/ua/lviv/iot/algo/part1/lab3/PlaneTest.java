package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaneTest {

    Plane plane;
    Plane plane_null = new Plane();

    @BeforeEach
    public void setUp() {
        plane = new Plane(90000, 120000,
                "Boeing", 460,
                35000, 3500);
    }

    @Test
    public void testGetMaxFlyingDistance() {
        int flightTime = plane.getFuelCapacity() / plane.getFuelPerHour();
        int maxFlyingDistance = plane.getMaxSpeed() * flightTime;
        assertEquals(maxFlyingDistance, plane.getMaxFlyingDistance());
    }

    @Test
    public void testGetMaxDeliveryWeight() {
        double maxDeliveryWeight = plane.getTakeOfWeight() - plane.getWeight();
        assertEquals(maxDeliveryWeight, plane.getMaxDeliveryWeight());
    }
}