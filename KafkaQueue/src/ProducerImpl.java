


public class ProducerImpl implements IProducer {

    final String name;
    final IQueueMediator queueMediator;


    public ProducerImpl(String name, IQueueMediator queueMediator) {
        this.name = name;
        this.queueMediator = queueMediator;
    }

    @Override
    public void publishToTopic(String message, String topicName) {
         System.out.println(" Send message "+ message +"to topic " + topicName);
         queueMediator.publishToTopic(new Message(message),topicName);
    }
}
