package main.unitility.context;

import main.ui.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContext {
    private final Map<Integer, Command> commands = new HashMap<>();

    private static CommandContext commandContext;

    private CommandContext() {
        commands.put(1, new ShowEntireCatalogue());
        commands.put(2, new AddNewElectricCar());
        commands.put(3, new AddNewGasCar());
        commands.put(4, new AddNewHybridCar());
        commands.put(5, new ShowCarTypeCatalogue());
        commands.put(6, new ShowCatalogueByCarName());
        commands.put(7, new CatalogueWriter());
    }

    public static CommandContext getCommandContext() {
        if (commandContext == null) {
            commandContext = new CommandContext();
        }

        return commandContext;
    }

    public void doAction(int actionNumber) {
        commands.get(actionNumber)
                .action();
    }
}
