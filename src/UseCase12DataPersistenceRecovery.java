import java.io.*;
import java.util.*;

class SystemState implements Serializable {
    Map<String, Integer> inventory;
    List<String> bookings;

    SystemState(Map<String, Integer> inventory, List<String> bookings) {
        this.inventory = inventory;
        this.bookings = bookings;
    }
}

class PersistenceService {

    void saveState(SystemState state, String fileName) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(state);
            oos.close();
            System.out.println("State saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving state");
        }
    }

    SystemState loadState(String fileName) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            SystemState state = (SystemState) ois.readObject();
            ois.close();
            System.out.println("State loaded successfully");
            return state;
        } catch (Exception e) {
            System.out.println("No previous state found. Starting fresh.");
            return null;
        }
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService service = new PersistenceService();
        String fileName = "system_state.dat";

        SystemState state = service.loadState(fileName);

        Map<String, Integer> inventory;
        List<String> bookings;

        if (state == null) {
            inventory = new HashMap<>();
            inventory.put("Deluxe", 2);
            inventory.put("Suite", 1);

            bookings = new ArrayList<>();
        } else {
            inventory = state.inventory;
            bookings = state.bookings;
        }

        System.out.println("Current Inventory: " + inventory);
        System.out.println("Booking History: " + bookings);

        if (inventory.get("Deluxe") > 0) {
            inventory.put("Deluxe", inventory.get("Deluxe") - 1);
            bookings.add("Deluxe Room Booked");
        }

        System.out.println("Updated Inventory: " + inventory);
        System.out.println("Updated Bookings: " + bookings);

        service.saveState(new SystemState(inventory, bookings), fileName);
    }
}