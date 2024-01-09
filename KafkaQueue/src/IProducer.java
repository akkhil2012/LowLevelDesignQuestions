public interface IProducer {
    void publishToTopic(String message,String topicName);
}
