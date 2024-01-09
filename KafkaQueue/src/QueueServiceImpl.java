public class QueueServiceImpl implements  IQueueService{

    public static QueueServiceImpl instance;

    private QueueServiceImpl(){

    }


    public  static QueueServiceImpl instace(){
        if(instance==null){
            instance = new QueueServiceImpl();
        }
        return  instance;
    }

    @Override
    public void createTopic() {

    }

    @Override
    public IProducer createProducer(String name) {
        return new ProducerImpl(name);
    }

    @Override
    public IConsumer createConsumer(String name) {
        return new ConsumerImpl(name);
    }
}
