import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String toString() {
        return guestName + " requested " + roomType;
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Lakshman", "Deluxe"));
        bookingQueue.add(new Reservation("Ravi", "Suite"));
        bookingQueue.add(new Reservation("Anu", "Standard"));

        System.out.println("Booking Requests in Queue:");

        for (Reservation r : bookingQueue) {
            System.out.println(r);
        }
    }
}