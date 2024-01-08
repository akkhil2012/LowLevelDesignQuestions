public interface RateLimiter {
    boolean canAccess(String client);
}
