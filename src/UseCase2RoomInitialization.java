/**
 * Use Case 2: Basic Room Types & Static Availability
 * Demonstrates abstraction, inheritance, and static availability.
 *
 * @author Lakshman
 * @version 2.1
 */

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("        Book My Stay Application    ");
        System.out.println("             Version 2.1            ");
        System.out.println("====================================");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("\nSingle Room Details:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailability);

        System.out.println("\nDouble Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailability);

        System.out.println("\nSuite Room Details:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailability);

    }
}