public class Slot {

    String slotNumber;

    Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isSlotFree() {
        return isSlotFree;
    }

    boolean isSlotFree;

    public void setSlotFree(boolean slotFree) {
        isSlotFree = slotFree;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public Slot(String slotNumber) {
        this.slotNumber = slotNumber;
    }


}
