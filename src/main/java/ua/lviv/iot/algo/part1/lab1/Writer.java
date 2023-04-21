package ua.lviv.iot.algo.part1.lab1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class Writer {

    public static final String ACTUAL_FILE =
            "src" + File.separator
            + "main" + File.separator
            + "java" + File.separator
            + "resources" + File.separator
            + "aircrafts.csv";
    public static final String ACTUAL_SORTED_FILE =
            "src" + File.separator
            + "main" + File.separator
            + "java" + File.separator
            + "resources" + File.separator
            + "aircrafts-sorted.csv";

    public void writeToFile(List<AerialVehicle> aircrafts) {
        if (!(aircrafts == null || aircrafts.isEmpty())) {
            try (FileWriter writer = new FileWriter(ACTUAL_FILE)) {
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
    }

    public void sortedWriteToFile(List<AerialVehicle> aircrafts) {
        if (!(aircrafts == null || aircrafts.isEmpty())) {

            List<Class<? extends AerialVehicle>> aircraftsType = aircrafts.stream()
                    .map(AerialVehicle::getClass)
                    .distinct()
                    .collect(Collectors.toList());

            try (FileWriter writer = new FileWriter(ACTUAL_SORTED_FILE)) {
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
}
