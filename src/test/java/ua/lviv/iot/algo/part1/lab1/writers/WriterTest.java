package ua.lviv.iot.algo.part1.lab1.writers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.AbstractTestUtils;
import ua.lviv.iot.algo.part1.lab1.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WriterTest {
    public static final String EXPECTED_SORTED_FILE = "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "expected-aircrafts-sorted.csv";

    AerialVehicleWriter writer;
    List<AerialVehicle> aircrafts;

    @BeforeEach
    void setUp() {
        writer = new AerialVehicleWriter();
        aircrafts = AbstractTestUtils.prepareAircrafts();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(AerialVehicleWriter.ACTUAL_SORTED_FILE));
    }

    @Test
    public void testSortedWriteNull() {
        writer.sortedWriteToFile(null);
        File result = new File(AerialVehicleWriter.ACTUAL_SORTED_FILE);
        assertFalse(result.exists());
    }

    @Test
    public void testSortedWriteToFile() throws IOException {
        writer.sortedWriteToFile(aircrafts);

        Path expected = new File(EXPECTED_SORTED_FILE).toPath();
        Path actual = new File(AerialVehicleWriter.ACTUAL_SORTED_FILE).toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testSortedRewriteToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter(AerialVehicleWriter.ACTUAL_SORTED_FILE)) {
            fileWriter.write("rewriting (sorted)...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testSortedWriteToFile();
    }
}