package main.ui;

import main.models.Vehicle;
import main.unitility.context.VehicleContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CatalogueWriter extends Command {
    @Override
    public void action() {
        super.action();
        List<Vehicle> readVehicles = VehicleContext
                .getVehicleContext()
                .getReadVehicles();

        List<Vehicle> newVehicles = VehicleContext
                .getVehicleContext()
                .getVehiclesToWrite();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/mobility.csv"))) {

            writeToFile(readVehicles, writer);
            writeToFile(newVehicles, writer);

            VehicleContext.getVehicleContext().clearVehicleList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(List<Vehicle> vehicles, BufferedWriter writer) throws IOException {
        for (Vehicle vehicle : vehicles) {
            writer.write(vehicle.toString());
            writer.newLine();
        }
    }
}
