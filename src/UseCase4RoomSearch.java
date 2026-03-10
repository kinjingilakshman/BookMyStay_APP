import java.util.HashMap;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        HashMap<String, Room> roomMap = new HashMap<>();
        roomMap.put("Single", single);
        roomMap.put("Double", doubleRoom);
        roomMap.put("Suite", suite);

        System.out.println("Available Rooms:\n");

        for (String type : inventory.getInventory().keySet()) {

            int available = inventory.getAvailability(type);

            if (available > 0) {

                Room room = roomMap.get(type);

                System.out.println("Room Type: " + type);
                System.out.println("Price: " + room.getPrice());
                System.out.println("Beds: " + room.getBeds());
                System.out.println("Size: " + room.getSize());
                System.out.println("Available: " + available);
                System.out.println("------------------------");
            }
        }
    }
}