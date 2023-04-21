package ua.lviv.iot.algo.part1.lab1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

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
            aircrafts.sort(Comparator.comparing(airctaft -> airctaft.getClass().getSimpleName()));
            try (FileWriter writer = new FileWriter(ACTUAL_SORTED_FILE)) {
                var aircraftType = aircrafts.get(0).getClass().getSimpleName();
                writer.write(aircraftType + "\n");
                writer.write(aircrafts.get(0).getHeaders() + "\n");

                for (var aircraft : aircrafts) {
                    if (!aircraft.getClass().getSimpleName().equals(aircraftType)) {
                        aircraftType = aircraft.getClass().getSimpleName();
                        writer.write("\n" + aircraftType + "\n");
                        writer.write(aircraft.getHeaders() + "\n");
                    }
                    writer.write(aircraft.toCSV() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
