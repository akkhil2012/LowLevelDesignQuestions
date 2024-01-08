

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingService {


    ParkingRespository parkingRespository;

    Map<Vehicle,Ticket> tickets;

    List<Vehicle> vehicles;

    public Map<Vehicle, Ticket> getTickets() {
        return tickets;
    }

    ParkingService(){
        parkingRespository = new ParkingRespository();
        tickets = new HashMap<>();
        vehicles = new ArrayList<>();
    }


    public List<Slot> finaAllAvailableSlots() {
            return parkingRespository.findAllSlots();

    }

    public void parkVehicle(String vehicleWithNumber,String parkToSlot) {
          Vehicle vehicle = new Vehicle(vehicleWithNumber);
          vehicles.add(vehicle);
        Slot slotToParkInto =
          parkingRespository.findAllSlots().stream()
                  .filter(slot -> slot.getSlotNumber().equals(parkToSlot) && !slot.isSlotFree())
                  .findAny()
                  .get();
          vehicle.setSlot(slotToParkInto);

          // create Ticket
          Ticket ticket = new Ticket();
          ticket.assignVehicle(vehicle);
          tickets.put(vehicle,ticket);

    }

    public void unparkVehicle(String vehicleWithNumber) {
        Vehicle vehicle1 =
        vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleWithNumber))
                .findAny()
                .get();
        Slot slot = vehicle1.getSlot();
        slot.setSlotFree(false);

        System.out.println(" Slot freed is " + slot +" by vehicle " + vehicle1.getVehicleNumber());

    }

    public void fetchTicketForVehicle(String vehicleNumber) {
        //getTickets().get(vehicleNumber).
    }
}
