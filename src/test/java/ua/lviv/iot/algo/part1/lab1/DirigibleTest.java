package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirigibleTest {

    Dirigible dirigible;
    Dirigible dirigible_null = new Dirigible();

    @BeforeEach
    public void setUp() {
        dirigible = new Dirigible(70000, 100000,
                "Zeppelin", 170,
                13000, 1300);
    }
    @Test
    public void testGetMaxFlyingDistance() {
        int flightTime = dirigible.getFuelCapacity() / dirigible.getFuelPerHour();
        int maxFlyingDistance = dirigible.getMaxSpeed() * flightTime;
        assertEquals(maxFlyingDistance, dirigible.getMaxFlyingDistance());
    }

    @Test
    public void testGetMaxDeliveryWeight() {
        double maxDeliveryWeight = dirigible.getTakeOfWeight() - dirigible.getWeight();
        assertEquals(maxDeliveryWeight, dirigible.getMaxDeliveryWeight());
    }
}