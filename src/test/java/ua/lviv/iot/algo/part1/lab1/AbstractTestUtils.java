package ua.lviv.iot.algo.part1.lab1;

import ua.lviv.iot.algo.part1.lab1.models.*;

import java.util.LinkedList;
import java.util.List;

public class AbstractTestUtils {

    public static List<AerialVehicle> prepareAircrafts() {
        List<AerialVehicle> aircrafts = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            aircrafts.add(new Helicopter(7000, 13000,
                    "Mi", 70,
                    101, "Hip",
                    2000, 3800,
                    2000, 200,
                    800));
            aircrafts.add(new Drone(10, 25,
                    "DeViro", 70,
                    300, 3));
            aircrafts.add(new Dirigible(70000, 130000,
                    "Zeppelin", 200,
                    13000, 130));
            aircrafts.add(new Plane(90000, 120000,
                    "Boeing", 460,
                    35000, 3500));
        }
        return aircrafts;
    }
}
