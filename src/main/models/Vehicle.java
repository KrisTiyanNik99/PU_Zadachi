package main.models;

import main.models.type.VehicleType;

/*
* Интерфейс клас който съдържа само най- основните характеристики на всички видове превозни средства.
* Според задачата това в момента са само коли, но в случай на евентуално бъдещо разширение този интерфейс
* съдържа само есенциалната и базо информация, за да не се налага да бъде променян в бъдеще.
*/
public interface Vehicle {
    void setBrand(VehicleType brand);
    VehicleType getBrand();

    void setVehicleName(String vehicleName);
    String getVehicleName();

    void setModelName(String modelName);
    String getModelName();

    void setPrice(int price);
    int getPrice();
}
