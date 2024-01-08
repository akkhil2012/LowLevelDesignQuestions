public abstract class CommandExecutor {

    public CommandExecutor(Command command, ParkingService service) {
        this.command = command;
        this.service = service;
    }

    protected Command command;
    protected ParkingService service;

    protected abstract boolean validate(Command command);

    protected abstract void executeCommand(Command command);


}
