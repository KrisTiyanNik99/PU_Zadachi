package main.ui;

import main.models.Vehicle;
import main.unitility.context.VehicleContext;

import java.util.Comparator;

public class ShowCarTypeCatalogue extends Command {
    @Override
    public void action() {
        super.action();
        VehicleContext.getVehicleContext()
                .getReadVehicles()
                .sort(Comparator.comparing(Vehicle::getBrand));

        VehicleContext.getVehicleContext()
                .getReadVehicles()
                .forEach(System.out::println);

        System.out.println();
    }
}
