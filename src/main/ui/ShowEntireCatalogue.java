package main.ui;

import main.unitility.context.VehicleContext;

public class ShowEntireCatalogue extends Command {
    @Override
    public void action() {
        super.action();
        VehicleContext.getVehicleContext()
                        .getReadVehicles()
                                .forEach(System.out::println);

        System.out.println();
    }
}
