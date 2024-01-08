

import java.util.ArrayList;
import java.util.List;

public class Floor {

    String floorNumber;

    public String getFloorNumber() {
        return floorNumber;
    }

    List<Slot> slots;

    public Floor(String floorNumber) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void assignSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
