package UseCase7AddOnServiceSelection;

import java.util.*;

class Service {
    String name;
    int cost;

    Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        Map<String, List<Service>> reservationServices = new HashMap<>();

        String r1 = "R1";
        String r2 = "R2";

        List<Service> s1 = new ArrayList<>();
        s1.add(new Service("Breakfast", 200));
        s1.add(new Service("Spa", 500));

        List<Service> s2 = new ArrayList<>();
        s2.add(new Service("Pickup", 800));

        reservationServices.put(r1, s1);
        reservationServices.put(r2, s2);

        for (String id : reservationServices.keySet()) {

            int total = 0;

            System.out.println("Reservation ID: " + id);

            for (Service s : reservationServices.get(id)) {
                System.out.println(s.name + " " + s.cost);
                total += s.cost;
            }

            System.out.println("Total: " + total);
        }
    }
}