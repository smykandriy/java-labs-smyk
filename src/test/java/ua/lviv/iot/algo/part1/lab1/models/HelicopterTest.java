package ua.lviv.iot.algo.part1.lab1.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.models.Helicopter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelicopterTest {
    Helicopter helicopter;
    Helicopter helicopterNull = new Helicopter();

    @BeforeEach
    public void setUp() {
        helicopter = new Helicopter(7000, 13000,
                "Mi", 70,
                101, "Hip",
                2000, 3800,
                2000, 200,
                800);
    }

    @Test
    public void testTakeOff() {
        int newCurrentAltidute = helicopter.getCurrentAltitude() + 100;
        helicopter.takeOff();
        assertEquals(newCurrentAltidute, helicopter.getCurrentAltitude());
    }

    @Test
    public void testAscend() {
        int newCurrentAltidute = helicopter.getCurrentAltitude() + 200;
        helicopter.ascend(200);
        assertEquals(newCurrentAltidute, helicopter.getCurrentAltitude());
        // ascend further than maxAltidute
        helicopter.ascend(20000);
        assertEquals(helicopter.getMaxAltitude(), helicopter.getCurrentAltitude());
    }

    @Test
    public void testDescend() {
        int newCurrentAltidute = helicopter.getCurrentAltitude() - 200;
        helicopter.descend(200);
        assertEquals(newCurrentAltidute, helicopter.getCurrentAltitude());
        // descend to 0m and lower
        helicopter.descend(20000);
        assertEquals(0, helicopter.getCurrentAltitude());
    }

    @Test
    public void refuel() {
        int newCurrentFuel = helicopter.getCurrentFuel() + 200;
        helicopter.refuel(200);
        assertEquals(newCurrentFuel, helicopter.getCurrentFuel());
        // add too more fuel
        helicopter.refuel(10000);
        assertEquals(helicopter.getFuelCapacity(), helicopter.getCurrentFuel());
    }

    @Test
    public void testGetMaxFlyingDistance() {
        int flightTime = helicopter.getFuelCapacity() / helicopter.getFuelPerHour();
        int maxFlyingDistance = helicopter.getMaxSpeed() * flightTime;
        assertEquals(maxFlyingDistance, helicopter.getMaxFlyingDistance());
    }

    @Test
    public void testGetMaxDeliveryWeight() {
        double maxDeliveryWeight = helicopter.getTakeOfWeight() - helicopter.getWeight();
        assertEquals(maxDeliveryWeight, helicopter.getMaxDeliveryWeight());
    }
}