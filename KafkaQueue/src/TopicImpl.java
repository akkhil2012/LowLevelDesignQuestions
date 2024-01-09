import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class TopicImpl implements  ITopic{
    private final List<Message> queue;
    private final ReentrantLock messageWriterReentrantLock;


    public TopicImpl(){
        
    }

    public TopicImpl(List<Message> queue, ReentrantLock messageWriterReentrantLock) {
        this.queue = queue;
        this.messageWriterReentrantLock = messageWriterReentrantLock;
    }

    @Override
    public void enqueueMessage(Message message) {

        messageWriterReentrantLock.lock();
        queue.add(message);
        messageWriterReentrantLock.unlock();

    }

    @Override
    public Optional<Message> readIfMessagePresent(int offset) {
        if(offset>queue.size())
            return Optional.empty();
        Message message = queue.get(offset);
        messageWriterReentrantLock.unlock();
        return  Optional.of(message);
    }
}














