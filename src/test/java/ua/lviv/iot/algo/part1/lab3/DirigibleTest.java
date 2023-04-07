package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirigibleTest {
    private final Dirigible dirible = new Dirigible(70000, 100000,
            "Zeppelin", 170,
            13000, 1300);

    @Test
    public void testGetMaxFlyingDistance() {
        int flightTime = dirible.getFuelCapacity() / dirible.getFuelPerHour();
        int maxFlyingDistance = dirible.getMaxSpeed() * flightTime;
        assertEquals(maxFlyingDistance, dirible.getMaxFlyingDistance());
    }

    @Test
    public void testGetMaxDeliveryWeight() {
        double maxDeliveryWeight = dirible.getTakeOfWeight() - dirible.getWeight();
        assertEquals(maxDeliveryWeight, dirible.getMaxDeliveryWeight());
    }
}