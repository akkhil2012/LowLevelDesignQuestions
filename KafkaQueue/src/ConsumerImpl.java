import java.util.*;

public class ConsumerImpl implements  IConsumer{
    private final  String name;
    private final IQueueMediator queueMediator;
    private final List<String> subscribedTopis;
    private final Map<String,Integer> topicToOffsetMap;

    public ConsumerImpl(String name) {
        this.name = name;
        this.queueMediator = QueueMediatorImpl.instance();
        this.subscribedTopis = new ArrayList<>();
        this.topicToOffsetMap = new HashMap<>();

        init();
    }



    private void init(){
        Thread messageCOnsumerThread = new Thread(this::consumerRunner);
        messageCOnsumerThread.start();

    }




    private void consumerRunner(){
        while(true){
            for(String topicName : subscribedTopis){
                int currentOffSet = topicToOffsetMap.get(topicName);
                Optional<Message> message = queueMediator.readMessageIfPresent(topicName,currentOffSet);
                if(message.isPresent()){
                    consume(message.get(),topicName,currentOffSet++);
                }
                topicToOffsetMap.put(topicName,currentOffSet);

            }


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private void consume(Message message, String topicName, int i) {

        System.out.println(" Message consumed is " + message +" from  topic " + topicName);
    }


}
