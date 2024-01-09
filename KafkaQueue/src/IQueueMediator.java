

import java.util.Optional;

public interface IQueueMediator {

    void addTopic(String name);

    void publishToTopic(Message message,String topicName);

    Optional<Message> readMessageIfPresent(String topicName,int offSet);
}
