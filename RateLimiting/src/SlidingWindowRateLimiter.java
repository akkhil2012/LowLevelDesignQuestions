import java.util.HashMap;
import java.util.Map;

public class SlidingWindowRateLimiter implements  RateLimiter{


   // SlidingWindow slidingWindow;

    Map<String,SlidingWindow> mapper;

    public SlidingWindowRateLimiter() {
        this.mapper = new HashMap<>();
    }

    @Override
    public boolean canAccess(String client) {
        if(mapper.containsKey(client)){
            SlidingWindow slidingWindow = mapper.get(client);
            return slidingWindow.canAccess(client);
        }
        SlidingWindow slidingWindow = new SlidingWindow(10,2);
        mapper.put(client,slidingWindow);
        return  slidingWindow.canAccess(client);
    }
}
