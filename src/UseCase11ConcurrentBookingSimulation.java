import java.util.*;

class BookingRequest {
    String guestName;
    String roomType;

    BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingSystem {

    Queue<BookingRequest> queue = new LinkedList<>();
    Map<String, Integer> inventory = new HashMap<>();

    BookingSystem() {
        inventory.put("Deluxe", 2);
        inventory.put("Suite", 1);
    }

    synchronized void addRequest(BookingRequest request) {
        queue.add(request);
    }

    synchronized BookingRequest getRequest() {
        return queue.poll();
    }

    synchronized void allocateRoom(BookingRequest request) {

        int available = inventory.getOrDefault(request.roomType, 0);

        if (available > 0) {
            inventory.put(request.roomType, available - 1);
            System.out.println(Thread.currentThread().getName() +
                    " booked " + request.roomType + " for " + request.guestName);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " failed booking for " + request.guestName);
        }
    }
}

class BookingProcessor extends Thread {

    BookingSystem system;

    BookingProcessor(BookingSystem system) {
        this.system = system;
    }

    public void run() {
        while (true) {
            BookingRequest request;

            synchronized (system) {
                request = system.getRequest();
            }

            if (request == null) break;

            system.allocateRoom(request);
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        BookingSystem system = new BookingSystem();

        system.addRequest(new BookingRequest("Lakshman", "Deluxe"));
        system.addRequest(new BookingRequest("Ravi", "Suite"));
        system.addRequest(new BookingRequest("Anu", "Deluxe"));
        system.addRequest(new BookingRequest("Kiran", "Suite"));

        BookingProcessor t1 = new BookingProcessor(system);
        BookingProcessor t2 = new BookingProcessor(system);

        t1.start();
        t2.start();
    }
}