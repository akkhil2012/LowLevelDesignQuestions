

import java.util.Arrays;
import java.util.List;

public class ParkingController {
    ParkingService service;
    List<CommandExecutor> listOfCommandExecutors;
    ParkingController(){
        service = new ParkingService();
        Command command = new Command();
        listOfCommandExecutors =
                List.of(new ParkVehicleExecutor(command,service),new UnParkExecutor(command,service));
    }

    public String parkVehicle(String vehicleNumber) throws Exception { // expected to return ticket
            List<Slot> slots =
                    service.finaAllAvailableSlots();
           // slots.stream().forEach(slot -> System.out.println(slot.getSlotNumber()));
            if(slots.size()==0){
                throw new SlotNotFoundException("Slot not available");
            }

            Slot availableSlot = slots.remove(0);
            Command command = new Command("park",List.of(vehicleNumber,availableSlot.getSlotNumber()));
            for(CommandExecutor executor : listOfCommandExecutors){
                if(executor.validate(command)){
                    executor.executeCommand(command);
                   // throw new Exception();
                }
                //executor.executeCommand(command);
            }
            return  "";
    }





    public String unParkVahicle(String vehicleNumber) throws Exception { // expected to return ticket
        service.fetchTicketForVehicle(vehicleNumber);
        Command command = new Command("unPark", Arrays.asList(vehicleNumber));
        for(CommandExecutor executor : listOfCommandExecutors){
            if(executor.validate(command)){
                executor.executeCommand(command);
               // throw new Exception();
            }
           // executor.executeCommand(command);
        }
        return  "";
    }





}
