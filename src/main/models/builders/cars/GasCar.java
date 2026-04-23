package main.models.builders.cars;

import main.constants.ErrorMessages;
import main.models.Vehicle;
import main.models.type.VehicleType;

import java.util.Locale;

// Клас който описва кола на газ
public class GasCar implements Vehicle {
    private VehicleType brand;
    private String vehicleName;
    private String modelName;
    private double engineDisplacement;
    private int powerOfTheEngine;
    private int price;

    protected GasCar(VehicleType brand, String vehicleName, String modelName, double engineDisplacement,
                     int powerOfTheEngine, int price) {
        setBrand(brand);
        setVehicleName(vehicleName);
        setModelName(modelName);
        setEngineDisplacement(engineDisplacement);
        setPowerOfTheEngine(powerOfTheEngine);
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

    public void setEngineDisplacement(double engineDisplacement) {
        if (engineDisplacement <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ENGINE_DISPLACEMENT);
        }

        this.engineDisplacement = engineDisplacement;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
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
        return String.format(Locale.US, "%s %s, %s, %.2fL, %dKW, %d euro",
                brand, vehicleName, modelName, engineDisplacement, powerOfTheEngine, price);
    }
}
