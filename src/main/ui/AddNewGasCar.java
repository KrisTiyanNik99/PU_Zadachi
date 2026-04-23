package main.ui;

import main.models.builders.VehicleBuilder;
import main.models.type.VehicleType;
import main.unitility.StaticDataDisplayer;
import main.unitility.context.BuilderContext;
import main.unitility.context.VehicleContext;

public class AddNewGasCar extends Command {
    @Override
    public void action() {
        StaticDataDisplayer.gasPoweredCarHelper();
        boolean isFullData = false;
        while (!isFullData) {
            try {
                VehicleType vehicleType = VehicleType.GAS_CAR;

                System.out.println("Lets start with the Mark of the car (Must be text):");
                String input = scanner.nextLine();
                String carMark = input;

                System.out.println("Let go with the Model name (Must be text):");
                input = scanner.nextLine();
                String modelName = input;

                System.out.println("Lets go with Power of the Engine (Must be Integer):");
                input = scanner.nextLine();
                int powerOfTheEngine = Integer.parseInt(input);

                System.out.println("Let go with the Engine Displacement (Must be Double):");
                input = scanner.nextLine();
                double engineDisplacement = Double.parseDouble(input);

                System.out.println("Finally we have to select a price (Must be Integer):");
                input = scanner.nextLine();
                int price = Integer.parseInt(input);

                VehicleBuilder vehicleBuilder = BuilderContext.getBuilderContext().getCorrectBuilder(vehicleType);
                String[] vehicleData = new String[]{vehicleType.toString(), carMark, modelName, String.valueOf(engineDisplacement),
                        String.valueOf(powerOfTheEngine), String.valueOf(price)};

                VehicleContext.getVehicleContext()
                        .setNewVehicleToContext(vehicleBuilder.parseDataToVehicle(vehicleData));

                System.out.println();
                isFullData = true;
            } catch (Exception ignored) {
                System.out.println("Parsing data failed! We need to start from the beginning!");
                System.out.println();
            }
        }
    }
}
