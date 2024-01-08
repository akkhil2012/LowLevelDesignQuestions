import java.util.List;

public class UnParkExecutor  extends  CommandExecutor{


    private String UNPARK_VECHICLE ="unPark";

    public UnParkExecutor(Command command, ParkingService service) {
        super(command, service);
    }

    @Override
    protected boolean validate(Command command) {
        if(command.getCommandToExecute().equals(UNPARK_VECHICLE))
            return true;
        return false;
    }

    @Override
    protected void executeCommand(Command command) {
        List<String> arguments = command.getCommandParameters();
        String vehicleToPark = arguments.get(0);
       // String slotToPark = arguments.get(1);
        service.unparkVehicle(vehicleToPark);




    }
}
