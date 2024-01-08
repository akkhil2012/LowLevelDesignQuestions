

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingRespository {

    final int  SLOT_CAPACITY=100;
    final int  FLOOR_COUNT=3;

    Map<String, Floor> floors;

    Map<String, Slot> slots;

    public ParkingRespository() {
        floors = new HashMap<>();
        slots = new HashMap<>();
        init(); // initilaize Parking

    }

    private void init(){
        for(int i=0;i<FLOOR_COUNT;i++){
            Floor floor = new Floor("Floor "+i);
            floors.put(floor.getFloorNumber(),floor);
            List<Slot> slotsInFloor = new ArrayList<>();
            for(int j=0;j<SLOT_CAPACITY;j++){
                Slot slot = new Slot("Slotno_" +j);
                slotsInFloor.add(slot);
                slots.put(slot.getSlotNumber(),slot);
            }
            floor.assignSlots(slotsInFloor);
        }
    }


    public List<Slot> findAllSlots(){
        return floors.entrySet().stream()
                .flatMap(floor -> floor.getValue().getSlots().stream())
                .collect(Collectors.toList());



    }



}
