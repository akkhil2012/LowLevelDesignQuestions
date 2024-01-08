import java.util.UUID;

public class Ticket {

    String ticketNumber;

    Vehicle vehicle;
    public Ticket() {
        this.ticketNumber = UUID.randomUUID().toString();
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
}
