package main.unitility.context;

import main.constants.ErrorMessages;
import main.models.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleContext {
    private final List<Vehicle> readVehicles;
    private final List<Vehicle> vehiclesToWrite;

    private static VehicleContext vehicleContext;

    private VehicleContext() {
        readVehicles = new ArrayList<>();
        vehiclesToWrite = new ArrayList<>();
    }

    public static VehicleContext getVehicleContext() {
        if (vehicleContext == null) {
            vehicleContext = new VehicleContext();
        }

        return vehicleContext;
    }

    public void setNewVehicleToContext(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException(ErrorMessages.NO_VEHICLE);
        }

        vehiclesToWrite.add(vehicle);
    }

    public void setVehicleToContext(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException(ErrorMessages.NO_VEHICLE);
        }

        readVehicles.add(vehicle);
    }

    public List<Vehicle> getVehiclesToWrite() {
        return vehiclesToWrite;
    }

    public List<Vehicle> getReadVehicles() {
        return readVehicles;
    }

    public void clearVehicleList() {
        vehiclesToWrite.clear();
        readVehicles.clear();
    }

    public boolean isReadVehicleListEmpty() {
        return readVehicles.isEmpty();
    }
}
