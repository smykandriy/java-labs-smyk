package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WriterTest {
    private static final String EXPECTED_FILE = "src\\test\\java\\resources\\expected-aircrafts.csv";
    private static final String EXPECTED_SORTED_FILE = "src\\test\\java\\resources\\expected-aircrafts-sorted.csv";

    Writer writer;
    AerialVehicleManager aircrafts;

    @BeforeEach
    void setUp() {
        writer = new Writer();
        aircrafts = new AerialVehicleManager();
        for (int i = 0; i < 2; i++) {
            aircrafts.addAerialVehicle(new Helicopter(7000, 13000,
                    "Mi", 70,
                    101, "Hip",
                    2000, 3800,
                    2000, 200,
                    800));
            aircrafts.addAerialVehicle(new Drone(10, 25,
                    "DeViro", 70,
                    300, 3));
            aircrafts.addAerialVehicle(new Dirigible(70000, 130000,
                    "Zeppelin", 200,
                    13000, 130));
            aircrafts.addAerialVehicle(new Plane(90000, 120000,
                    "Boeing", 460,
                    35000, 3500));
        }
    }

    @Test
    public void testWriteNull() throws IOException {
        writer.writeToFile(null);
        File result = new File("src\\main\\java\\resources\\aircrafts.csv");
        assertFalse(result.exists());
    }

    @Test
    public void testWriteToFile() throws IOException {
        writer.writeToFile(aircrafts.getAircraftsList());

        Path expected = new File(EXPECTED_FILE).toPath();
        Path actual = new File("src//main//java//resources//aircrafts.csv").toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testRewriteToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("src//main//java//resources//aircrafts.csv")) {
            fileWriter.write("rewriting...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testWriteToFile();
    }

    @Test
    public void testSortedWriteNull() {
        writer.sortedWriteToFile(null);
        File result = new File("src//main//java//resources//aircrafts-sorted.csv");
        assertFalse(result.exists());
    }

    @Test
    public void testSortedWriteToFile() throws IOException {
        writer.sortedWriteToFile(aircrafts.getAircraftsList());

        Path expected = new File(EXPECTED_SORTED_FILE).toPath();
        Path actual = new File("src//main//java//resources//aircrafts-sorted.csv").toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testSortedRewriteToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("src//main//java//resources//aircrafts-sorted.csv")) {
            fileWriter.write("rewriting (sorted)...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testSortedWriteToFile();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("src\\main\\java\\resources\\aircrafts.csv"));
        Files.deleteIfExists(Path.of("src\\main\\java\\resources\\aircrafts-sorted.csv"));
    }
}