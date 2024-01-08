public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        RateLimiter rateLimiter = new SlidingWindowRateLimiter();

        for(int i=0;i<10;i++){
          //  rateLimiter.canAccess("test");
            System.out.println("Is allowed...." + rateLimiter.canAccess("test"));
           // Thread.sleep(300);
        }
    }
}