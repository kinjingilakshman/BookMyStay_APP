import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class BookingValidator {

    Set<String> validRoomTypes = new HashSet<>(Arrays.asList("Deluxe", "Suite"));

    void validate(String roomType, int availableRooms) throws InvalidBookingException {

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        if (availableRooms <= 0) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }
    }
}

class BookingService {

    Map<String, Integer> inventory = new HashMap<>();

    BookingService() {
        inventory.put("Deluxe", 2);
        inventory.put("Suite", 1);
    }

    void bookRoom(String guestName, String roomType) {

        BookingValidator validator = new BookingValidator();

        try {

            int available = inventory.getOrDefault(roomType, 0);

            validator.validate(roomType, available);

            inventory.put(roomType, available - 1);

            System.out.println("Booking confirmed for " + guestName + " in " + roomType);

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        BookingService service = new BookingService();

        service.bookRoom("Lakshman", "Deluxe");
        service.bookRoom("Ravi", "Suite");
        service.bookRoom("Anu", "Suite");
        service.bookRoom("Kiran", "Premium");
    }
}