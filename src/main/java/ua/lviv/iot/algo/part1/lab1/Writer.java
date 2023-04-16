package ua.lviv.iot.algo.part1.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class Writer {
    public void writeToFile(List<AerialVehicle> aircrafts) {
        if (aircrafts == null || aircrafts.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter("src//main//java//resources//aircrafts.csv")) {
            for (var aircraft : aircrafts) {
                writer.write(aircraft.getClass().getSimpleName() + "\n");
                writer.write(aircraft.getHeaders());
                writer.write(" \r\n");
                writer.write(aircraft.toCSV());
                writer.write(" \r\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortedWriteToFile(List<AerialVehicle> aircrafts) {
        if (aircrafts == null || aircrafts.isEmpty()) {
            return;
        }

        List<Class<? extends AerialVehicle>> aircraftsType = aircrafts.stream()
                .map(AerialVehicle::getClass)
                .distinct()
                .collect(Collectors.toList());

        try (FileWriter writer = new FileWriter("src//main//java//resources//aircrafts-sorted.csv")) {
            for (var aircraftType : aircraftsType) {
                writer.write(aircraftType.getSimpleName() + "\n");
                writer.write(String.valueOf(aircraftType.getDeclaredMethod("getHeaders")
                        .invoke(aircraftType.getDeclaredConstructor().newInstance())));
                writer.write("\n");

                for (var aircraft : aircrafts) {
                    if (aircraftType == aircraft.getClass()) {
                        writer.write(aircraft.toCSV() + "\n");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException
                 | NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException
                 | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
