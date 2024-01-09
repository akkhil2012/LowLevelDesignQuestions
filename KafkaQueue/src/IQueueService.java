public interface IQueueService {

    void createTopic();

    IProducer createProducer(String name);

    IConsumer createConsumer(String name);
}
