package main;

import main.unitility.StaticDataDisplayer;
import main.unitility.context.CommandContext;

import java.util.Scanner;

public class Launcher {
    public static void LaunchApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello from Mobility4You!");
        StaticDataDisplayer.displayOptions();
        System.out.println();

        int userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice != 8) {
            if (userChoice <= 0 || userChoice > 8) {
                System.out.println("Invalid choice! Please select try to again!");
                StaticDataDisplayer.displayOptions();
                System.out.println();
                userChoice = Integer.parseInt(scanner.nextLine());
                continue;
            }

            CommandContext.getCommandContext()
                    .doAction(userChoice);

            StaticDataDisplayer.displayOptions();
            userChoice = Integer.parseInt(scanner.nextLine());
        }
    }
}
