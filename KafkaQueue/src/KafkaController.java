public class KafkaController {

    public static void main(String aths[]){
        IQueueService queueService = QueueServiceImpl.instace();

        IProducer producer1 = queueService.createProducer("producer1");

        IConsumer consumer1 = queueService.createConsumer("Consumer1");


        consumer1.subscribeTopic("topic1");

        producer1.publishToTopic("topic1");


    }
}
