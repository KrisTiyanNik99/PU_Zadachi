package main.ui;

import main.constants.ErrorMessages;
import main.unitility.context.VehicleContext;
import main.unitility.parser.DataParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Command {
    protected static final String DATABASE_PATH = "src/main/resources/mobility.csv";

    private final List<String> rowDataLine = new ArrayList<>();
    protected Scanner scanner = new Scanner(System.in);

    public void action() {
        try (BufferedReader reader = Files.newBufferedReader(
                Path.of(DATABASE_PATH),
                StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                rowDataLine.add(line);
            }

            if (VehicleContext.getVehicleContext().isReadVehicleListEmpty()) {
                rowDataLine.forEach(e ->
                        VehicleContext.getVehicleContext()
                                .setVehicleToContext(DataParser.getVehicleFromDataRow(e))
                );
            }

            rowDataLine.clear();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
