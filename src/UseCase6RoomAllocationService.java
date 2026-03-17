import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Lakshman", "Deluxe"));
        queue.add(new Reservation("Ravi", "Suite"));
        queue.add(new Reservation("Anu", "Deluxe"));

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Deluxe", 2);
        inventory.put("Suite", 1);

        Map<String, Set<String>> allocatedRooms = new HashMap<>();
        Set<String> usedRoomIds = new HashSet<>();

        int roomCounter = 1;

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();

            if (inventory.getOrDefault(r.roomType, 0) > 0) {

                String roomId = r.roomType + "-" + roomCounter++;

                if (!usedRoomIds.contains(roomId)) {

                    usedRoomIds.add(roomId);

                    allocatedRooms.putIfAbsent(r.roomType, new HashSet<>());
                    allocatedRooms.get(r.roomType).add(roomId);

                    inventory.put(r.roomType, inventory.get(r.roomType) - 1);

                    System.out.println(r.guestName + " booking confirmed. Room ID: " + roomId);
                }

            } else {
                System.out.println(r.guestName + " booking failed. No rooms available.");
            }
        }
    }
}
