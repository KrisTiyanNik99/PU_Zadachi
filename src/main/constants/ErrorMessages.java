package main.constants;
/*
* Това е константен клас в който ще се съдържат само съобщения за грешки. Съобщенията са генерални и няма да изискват
* промяна. Поради тази причина всички полета са static final String, защото те ще са генерални, трябва да принадлежат на
* самия клас и ще се използват за насочване на потребителя на кода или приложението.
*/
public final class ErrorMessages {
    public static final String BRAND_NOT_BLANK = "Brand cannot be null or empty string!";
    public static final String VEHICLE_NAME_NOT_BLANK = "Vehicle Name cannot be null or empty!";
    public static final String MODEL_NAME_NOT_BLANK = "Model Name cannot be empty string!";
    public static final String POWER_OF_THE_ENGINE_NOT_ZERO = "The power of the engine cannot be zero or less!";
    public static final String CAPACITY_OF_THE_BATTERY_NOT_ZERO = "The capacity of the battery cannot be zero or less!";
    public static final String PRICE_NOT_ZERO = "The item cannot be free or price cannot be less than zero!";
    public static final String ENGINE_DISPLACEMENT = "Engine Displacement cannot be null or zero!";
    public static final String NOT_ENOUGH_DATA = "Data cannot be parsed. You data is incomplete and something is missing!";
    public static final String NOT_SUPPORTED_VEHICLE_TYPE = "Not supported vehicle type! Please check again you vehicle type!";
    public static final String INTEGER_POWER_ENGINE = "Power of the engine must be INTEGER type value!";
    public static final String INTEGER_PRICE = "Price for the car must be INTEGER type value!";
    public static final String INTEGER_BATTERY_CAPACITY = "Capacity of the battery must be INTEGER type value!";
    public static final String DOUBLE_ENGINE_DISPLACEMENT = "Engine Displacement must be DOUBLE type value!";
    public static final String EMPTY_RECORD = "This record is null or empty!";
    public static final String NO_VEHICLE = "Must have a vehicle instance for this method!";
    public static final String FILE_NOT_FOUND = "File not found!";
}
