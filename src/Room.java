public abstract class Room {

    protected int beds;
    protected String size;
    protected int price;

    public int getBeds() {
        return beds;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size);
        System.out.println("Price: " + price);
    }
}