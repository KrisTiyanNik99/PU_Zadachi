package main.unitility.parser;

import main.constants.ErrorMessages;
import main.models.Vehicle;
import main.models.builders.VehicleBuilder;
import main.models.type.VehicleType;
import main.unitility.context.BuilderContext;

public class DataParser {
    private static final String POWER_ENGINE_SPLITTER = "KW";
    private static final String BATTERY_CAPACITY_SPLITTER = "Ah";
    private static final String ENGINE_DISPLACEMENT_SPLITTER = "L";
    private static final String PRICE_SPLITTER = "euro";
    private static final int VALUE_POSITION = 0;


    public static Vehicle getVehicleFromDataRow(String dataRow) {
        if (dataRow == null || dataRow.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_RECORD);
        }

        String[] parts = dataRow.split(",\\s*");
        String firstPart = parts[0];
        String[] firstSplit = firstPart.split(" ", 2);

        // нов масив с правилния размер
        String[] result = new String[parts.length + 1];

        // добавяме първите 2 елемента
        result[0] = firstSplit[0];
        result[1] = firstSplit[1];

        // копираме останалите
        System.arraycopy(parts, 1, result, 2, parts.length - 1);
        VehicleType vehicleType = VehicleType.valueOf(result[0]);
        VehicleBuilder vehicleBuilder = BuilderContext.getBuilderContext().getCorrectBuilder(vehicleType);
        return vehicleBuilder.parseDataToVehicle(result);
    }

    /*
    * Помощни методи за парсване на информацията. Това са статични методи принадлежащи на Util класа. Хардкоднати са
    * по този начин, защото каталога не е голям, а методите са малки и прости, но при бъдещо голямо разрастване трябва
    * да се помисли за смяна на "базата от данни" или преминаването на factory pattern.
    */
    public static int getPowerOfEngineFromData(String data) {
        try {
            return Integer.parseInt(data.split(POWER_ENGINE_SPLITTER)[VALUE_POSITION].trim());
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessages.INTEGER_POWER_ENGINE);
        }
    }

    public static int getCapacityOfTheBatteryFromData(String data) {
        try {
            return Integer.parseInt(data.split(BATTERY_CAPACITY_SPLITTER)[VALUE_POSITION].trim());
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessages.INTEGER_BATTERY_CAPACITY);
        }
    }

    public static int getPriceFromData(String data) {
        try {
            return Integer.parseInt(data.split(PRICE_SPLITTER)[VALUE_POSITION].trim());
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessages.INTEGER_PRICE);
        }
    }

    public static double getEngineDisplacement(String data) {
        try {
            return Double.parseDouble(data.split(ENGINE_DISPLACEMENT_SPLITTER)[VALUE_POSITION].trim());
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessages.DOUBLE_ENGINE_DISPLACEMENT);
        }
    }
}
