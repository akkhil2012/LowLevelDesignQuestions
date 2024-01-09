import java.util.Map;
import java.util.Optional;

public class QueueMediatorImpl implements  IQueueMediator{


    private final Map<String,ITopic> topicHashMap;

    public QueueMediatorImpl(Map<String, ITopic> topicHashMap) {
        this.topicHashMap = topicHashMap;
    }

    @Override
    public void addTopic(String name) {
        if(!topicHashMap.containsKey(name)){
            topicHashMap.put(name,new TopicImpl());
        }
    }

    @Override
    public void publishToTopic(Message message, String topicName) {
        topicHashMap.get(topicName).enqueueMessage(message);
    }

    @Override
    public Optional<Message> readMessageIfPresent(String topicName, int offSet) {
        return topicHashMap.get(topicName).readIfMessagePresent(offSet);
        //return Optional.empty();
    }
}
