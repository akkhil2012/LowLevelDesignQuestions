import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindow {
    private int timeSpanAllowed;
    private int REQUEST_COUNT;
    Queue<Long> queue;

    public SlidingWindow(int timeSpanAllowed, int REQUEST_COUNT) {
        this.timeSpanAllowed = timeSpanAllowed;
        this.REQUEST_COUNT = REQUEST_COUNT;
        this.queue = new ArrayDeque<>();
    }


    public boolean canAccess(String client) {
        long currentTime = System.currentTimeMillis();
        int size = checkWindowSize(currentTime);
        if(queue.size()>=REQUEST_COUNT){
           return false;
        }

        queue.add(currentTime);
        return true;
    }


    private int checkWindowSize(long currentTime){
        if(queue.isEmpty())
            return 0;

        long diff = currentTime-queue.peek();
        while(!queue.isEmpty() && diff>timeSpanAllowed){
            queue.poll();
            if(queue.isEmpty())break;
            diff=currentTime-queue.peek();
        }
        return queue.size();
    }

}
