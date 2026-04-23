package main.models.builders.cars;

import main.constants.ErrorMessages;
import main.models.Vehicle;
import main.models.builders.VehicleBuilder;
import main.models.type.VehicleType;
import main.unitility.parser.DataParser;

/*
* Поради ограниченото разнообразие в случая Factory method pattern ще ни свърши чудесна работа. Въпреки това тази структура
* предразполага бързо, лесно и гъвкаво скалиране на кода. Например ако в последствие се разрастнат структурите и разнообразието
* този метод може да се изчисти и да се направи inheritance или някакъв друг вид преструктуриране на йерархията.
*/
public class CarBuilder extends VehicleBuilder {
    private static final int ELECTRIC_CAR_DATA_LENGTH = 6;
    private static final int GAS_CAR_DATA_LENGTH = 6;
    private static final int HYBRID_CAR_DATA_LENGTH = 7;

    @Override
    public boolean isBuildingType(VehicleType vehicleType) {
        return vehicleType.equals(VehicleType.ELECTRIC_CAR) ||
                vehicleType.equals(VehicleType.GAS_CAR) || vehicleType.equals(VehicleType.HYBRID_CAR);
    }

    @Override
    protected Vehicle getVehicleByType(VehicleType vehicleType, String[] vehicleData) {
        switch (vehicleType) {
            case ELECTRIC_CAR:
                return getElectricCar(vehicleType, vehicleData);
            case GAS_CAR:
                return getGasCar(vehicleType, vehicleData);
            case HYBRID_CAR:
                return getHybridCar(vehicleType, vehicleData);
            default:
                throw new IllegalArgumentException(ErrorMessages.NOT_SUPPORTED_VEHICLE_TYPE);
        }
    }

    protected Vehicle getElectricCar(VehicleType vehicleType, String[] vehicleData) {
        checkForEnoughData(vehicleData, ELECTRIC_CAR_DATA_LENGTH);

        int powerOfTheEngine = DataParser.getPowerOfEngineFromData(vehicleData[3]);
        int capacityOfTheBattery = DataParser.getCapacityOfTheBatteryFromData(vehicleData[4]);
        int carPrice = DataParser.getPriceFromData(vehicleData[5]);

        return new ElectricCar(vehicleType, vehicleData[1], vehicleData[2], powerOfTheEngine,
                capacityOfTheBattery, carPrice);
    }

    protected Vehicle getGasCar(VehicleType vehicleType, String[] vehicleData) {
        checkForEnoughData(vehicleData, GAS_CAR_DATA_LENGTH);

        double engineDisplacement = DataParser.getEngineDisplacement(vehicleData[3]);
        int powerOfTheEngine = DataParser.getPowerOfEngineFromData(vehicleData[4]);
        int carPrice = DataParser.getPriceFromData(vehicleData[5]);

        return new GasCar(vehicleType, vehicleData[1], vehicleData[2], engineDisplacement,
                powerOfTheEngine, carPrice);
    }

    protected Vehicle getHybridCar(VehicleType vehicleType, String[] vehicleData) {
        checkForEnoughData(vehicleData, HYBRID_CAR_DATA_LENGTH);

        double engineDisplacement = DataParser.getEngineDisplacement(vehicleData[3]);
        int powerOfTheEngine = DataParser.getPowerOfEngineFromData(vehicleData[4]);
        int capacityOfTheBattery = DataParser.getCapacityOfTheBatteryFromData(vehicleData[5]);
        int carPrice = DataParser.getPriceFromData(vehicleData[6]);

        return new HybridCar(vehicleType, vehicleData[1], vehicleData[2], engineDisplacement,
                powerOfTheEngine, capacityOfTheBattery, carPrice);
    }
}
