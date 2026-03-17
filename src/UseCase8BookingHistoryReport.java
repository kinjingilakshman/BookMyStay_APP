import java.util.*;

class BookingRecord {
    String guestName;
    String roomType;
    String roomId;

    BookingRecord(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

class BookingHistory {
    List<BookingRecord> history = new ArrayList<>();

    void addReservation(BookingRecord r) {
        history.add(r);
    }

    List<BookingRecord> getAll() {
        return history;
    }
}

class BookingReportService {

    void generateReport(List<BookingRecord> list) {

        System.out.println("Booking History Report:");

        Map<String, Integer> count = new HashMap<>();

        for (BookingRecord r : list) {
            System.out.println(r.guestName + " | " + r.roomType + " | " + r.roomId);
            count.put(r.roomType, count.getOrDefault(r.roomType, 0) + 1);
        }

        System.out.println("\nSummary:");

        for (String type : count.keySet()) {
            System.out.println(type + " rooms booked: " + count.get(type));
        }
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new BookingRecord("Lakshman", "Deluxe", "Deluxe-1"));
        history.addReservation(new BookingRecord("Ravi", "Suite", "Suite-1"));
        history.addReservation(new BookingRecord("Anu", "Deluxe", "Deluxe-2"));

        BookingReportService reportService = new BookingReportService();

        reportService.generateReport(history.getAll());
    }
}