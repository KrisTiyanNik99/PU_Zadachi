package main.models.builders.cars;

import main.constants.ErrorMessages;
import main.models.Vehicle;
import main.models.type.VehicleType;

// Клас който описва Електрическа кола
public class ElectricCar implements Vehicle {
    private VehicleType brand;
    private String vehicleName;
    private String modelName;
    private int powerOfTheEngine;
    private int capacityOfTheBattery;
    private int price;

    /*
    * Използвам конструктор, който е protected, защото той ще бъде използван в builder класа за да създава
    * инстанции от класа който ми трябва. Protected позволява достъп до методите само на наследници или класове,
    * които са в същата папка.
    */
    protected ElectricCar(VehicleType brand, String vehicleName, String modelName, int powerOfTheEngine,
                          int capacityOfTheBattery, int price) {
        setBrand(brand);
        setVehicleName(vehicleName);
        setModelName(modelName);
        setPowerOfTheEngine(powerOfTheEngine);
        setCapacityOfTheBattery(capacityOfTheBattery);
        setPrice(price);
    }

    @Override
    public void setBrand(VehicleType brand) {
        if (brand == null) {
            throw new IllegalArgumentException(ErrorMessages.BRAND_NOT_BLANK);
        }

        this.brand = brand;
    }

    @Override
    public VehicleType getBrand() {
        return brand;
    }

    @Override
    public void setVehicleName(String vehicleName) {
        if (vehicleName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.VEHICLE_NAME_NOT_BLANK);
        }

        this.vehicleName = vehicleName;
    }

    @Override
    public String getVehicleName() {
        return vehicleName;
    }

    @Override
    public void setModelName(String modelName) {
        if (modelName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.MODEL_NAME_NOT_BLANK);
        }

        this.modelName = modelName;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    public void setPowerOfTheEngine(int powerOfTheEngine) {
        if (powerOfTheEngine <= 0) {
            throw new IllegalArgumentException(ErrorMessages.POWER_OF_THE_ENGINE_NOT_ZERO);
        }

        this.powerOfTheEngine = powerOfTheEngine;
    }

    public int getPowerOfTheEngine() {
        return powerOfTheEngine;
    }

    public void setCapacityOfTheBattery(int capacityOfTheBattery) {
        if (capacityOfTheBattery <= 0) {
            throw new IllegalArgumentException(ErrorMessages.CAPACITY_OF_THE_BATTERY_NOT_ZERO);
        }

        this.capacityOfTheBattery = capacityOfTheBattery;
    }

    public int getCapacityOfTheBattery() {
        return capacityOfTheBattery;
    }

    @Override
    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessages.PRICE_NOT_ZERO);
        }

        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %dKW, %dAh, %d euro",
                brand, vehicleName,modelName, powerOfTheEngine, capacityOfTheBattery, price);
    }
}
