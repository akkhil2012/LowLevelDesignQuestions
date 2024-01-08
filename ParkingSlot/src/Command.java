import java.util.List;

public class Command {

    public String commandToExecute;

    public Command(){

    }

    public Command(String commandToExecute, List<String> commandParameters) {
        this.commandToExecute = commandToExecute;
        this.commandParameters = commandParameters;
    }

    public String getCommandToExecute() {
        return commandToExecute;
    }

    public List<String> getCommandParameters() {
        return commandParameters;
    }

    List<String> commandParameters;


}
