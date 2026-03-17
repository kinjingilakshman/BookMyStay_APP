import java.util.*;

class Booking {
    String guestName;
    String roomType;
    String roomId;

    Booking(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

class CancellationService {

    Map<String, Integer> inventory = new HashMap<>();
    Map<String, Booking> confirmedBookings = new HashMap<>();
    Stack<String> rollbackStack = new Stack<>();

    CancellationService() {
        inventory.put("Deluxe", 1);
        inventory.put("Suite", 1);
    }

    void confirmBooking(String guestName, String roomType, String roomId) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            Booking b = new Booking(guestName, roomType, roomId);
            confirmedBookings.put(roomId, b);
            inventory.put(roomType, available - 1);
            System.out.println("Booking confirmed: " + roomId);
        } else {
            System.out.println("No rooms available for " + roomType);
        }
    }

    void cancelBooking(String roomId) {

        if (!confirmedBookings.containsKey(roomId)) {
            System.out.println("Cancellation failed: Booking not found");
            return;
        }

        Booking b = confirmedBookings.remove(roomId);

        rollbackStack.push(roomId);

        int available = inventory.getOrDefault(b.roomType, 0);
        inventory.put(b.roomType, available + 1);

        System.out.println("Booking cancelled: " + roomId);
    }

    void showInventory() {
        System.out.println("Current Inventory: " + inventory);
    }

    void showRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        service.confirmBooking("Lakshman", "Deluxe", "D1");
        service.confirmBooking("Ravi", "Suite", "S1");

        service.showInventory();

        service.cancelBooking("D1");

        service.showInventory();
        service.showRollbackStack();

        service.cancelBooking("D1");
    }
}