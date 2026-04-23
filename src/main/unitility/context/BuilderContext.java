package main.unitility.context;

import main.models.builders.VehicleBuilder;
import main.models.builders.cars.CarBuilder;
import main.models.type.VehicleType;

import java.util.ArrayList;
import java.util.List;

// Singleton клас, който е контейнер за инстанции на класовете, които мога да създават различните типове превозни средства
// Наподобява IoC контейнера в Spring Boot (Application Context)
public class BuilderContext {
    private final List<VehicleBuilder> vehicleBuilders = new ArrayList<>();

    private static BuilderContext builderContext;

    private BuilderContext() {
        vehicleBuilders.add(new CarBuilder());
    }

    public static BuilderContext getBuilderContext() {
        if (builderContext == null) {
            builderContext = new BuilderContext();
        }

        return builderContext;
    }

    public VehicleBuilder getCorrectBuilder(VehicleType vehicleType) {
        return vehicleBuilders.stream()
                .filter(e -> e.isBuildingType(vehicleType))
                .findFirst()
                .orElseThrow();
    }
}
