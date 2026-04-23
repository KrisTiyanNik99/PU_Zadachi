package main.unitility;

public class StaticDataDisplayer {
    public static void displayOptions() {
        System.out.println("Please make your choice:");
        System.out.println("1 - Show the entire Mobility4You catalogue");
        System.out.println("2 – Add a new electric car");
        System.out.println("3 – Add a new gas-powered car");
        System.out.println("4 – Add a new hybrid car");
        System.out.println("5 - Show the entire Mobility4You catalogue sorted by car-type");
        System.out.println("6 – Show the entire Mobility4You catalogue sorted by brand (alphabetically)");
        System.out.println("7 – Write to file");
        System.out.println("8 – Stop the program");
        System.out.println();
    }

    public static void electricCarHelper() {
        System.out.println("Electric car need this values to be provided: ");
        System.out.println("String brand, String vehicleName, String modelName, int powerOfTheEngine, int capacityOfTheBattery and int price");
        System.out.println();
    }

    public static void gasPoweredCarHelper() {
        System.out.println("Gas powered car need this values to be provided: ");
        System.out.println("String brand, String vehicleName, String modelName, double engineDisplacement, int powerOfTheEngine, int price");
        System.out.println();
    }

    public static void hybridPoweredCarHelper() {
        System.out.println("Hybrid powered car need this values to be provided: ");
        System.out.println("String brand, String vehicleName, String modelName, double engineDisplacement, int powerOfTheEngine, int capacityOfTheBattery, int price");
        System.out.println();
    }
}
