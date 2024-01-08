import java.util.List;

public class ParkVehicleExecutor extends  CommandExecutor{

    private String PARK_VECHICLE ="park";

    public ParkVehicleExecutor(Command command, ParkingService service) {
        super(command, service);
    }

    @Override
    protected boolean validate(Command command) {
        if(command.getCommandToExecute().equals(PARK_VECHICLE))
            return true;
        return false;
    }

    @Override
    protected void executeCommand(Command command) {
          List<String> arguments = command.getCommandParameters();
          String vehicleToPark = arguments.get(0);
          String slotToPark = arguments.get(1);
         service.parkVehicle(vehicleToPark,slotToPark);
    }
}
