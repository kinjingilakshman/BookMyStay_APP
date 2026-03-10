/**
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates how HashMap centralizes room availability.
 *
 * @author Lakshman
 * @version 3.1
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("        Book My Stay Application    ");
        System.out.println("             Version 3.1            ");
        System.out.println("====================================");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nUpdating Suite Room availability...");

        inventory.updateAvailability("Suite Room", 4);

        inventory.displayInventory();
    }
}