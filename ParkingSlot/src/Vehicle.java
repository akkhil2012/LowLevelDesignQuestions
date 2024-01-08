public class Vehicle {

    private String vehicleNumber;

    Slot slot;

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
