import java.util.Scanner;

public class SatelliteCommandSystem {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (rotate, activate, deactivate, collect, exit):");
            String input = scanner.nextLine();

            switch (input) {
                case "rotate":
                    System.out.println("Enter direction (North, South, East, West):");
                    String direction = scanner.nextLine();
                    invoker.executeCommand(new RotateCommand(direction), satellite);
                    break;
                case "activate":
                    invoker.executeCommand(new ActivatePanelsCommand(), satellite);
                    break;
                case "deactivate":
                    invoker.executeCommand(new DeactivatePanelsCommand(), satellite);
                    break;
                case "collect":
                    try {
                        invoker.executeCommand(new CollectDataCommand(), satellite);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }

            // Print the current state of the satellite
            System.out.println("Current State: Orientation = " + satellite.getOrientation() +
                               ", Solar Panels Active = " + satellite.areSolarPanelsActive() +
                               ", Data Collected = " + satellite.getDataCollected());
        }
    }
}
