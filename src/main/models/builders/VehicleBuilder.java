package main.models.builders;

import main.constants.ErrorMessages;
import main.models.Vehicle;
import main.models.type.VehicleType;

public abstract class VehicleBuilder {
    private static final int BASE_VEHICLE_DATA_LENGTH = 4;
    private static final int VEHICLE_TYPE_POSITION = 0;

    public Vehicle parseDataToVehicle(String[] vehicleData) {
        if (vehicleData.length < BASE_VEHICLE_DATA_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ENOUGH_DATA);
        }

        VehicleType vehicleType = VehicleType.valueOf(vehicleData[VEHICLE_TYPE_POSITION]);
        return getVehicleByType(vehicleType, vehicleData);
    }

    /*
     * Метод който е void и ще се извиква в наследниците. Това е важна проверка. С цел да спесвим писане на едно и също
     * нещо този метод е позициониран тук в бащиния клас. Метода е void, защото нищо не трябва да връща, само ако не съответства
     * да даде грешка при изпълнение
    */
    protected void checkForEnoughData(String[] vehicleData, int mustDataLength) {
        if (vehicleData.length < mustDataLength) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ENOUGH_DATA);
        }
    }

    public abstract boolean isBuildingType(VehicleType vehicleType);

    protected abstract Vehicle getVehicleByType(VehicleType vehicleType, String[] vehicleData);
}
