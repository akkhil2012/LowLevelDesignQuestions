import java.util.Optional;

public interface ITopic {

    void enqueueMessage(Message message);
    Optional<Message>  readIfMessagePresent(int offset);
}
