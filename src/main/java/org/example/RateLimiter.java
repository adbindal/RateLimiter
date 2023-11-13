package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: Rate Limiter
 *
 * Per customer rate limit, each customer can make x request per y seconds
 *
 * Perform rate limiting logic for provided customer ID. Return true if the
 *
 * No. of users - 10M (can store in HashMap)
 *
 * @return true if request is allowed, else false
 *
 * boolean rateLimit(int customerId)
 */
public class RateLimiter {

    private final Map<Integer, RateLimitItem> rateLimitPerCustomer = new HashMap<Integer, RateLimitItem>();
    private final int maxSeconds;
    private final int maxRequests;

    RateLimiter(int numRequests, int numSeconds) {
        this.maxRequests = numRequests;
        this.maxSeconds = numSeconds;
    }

    public boolean rateLimit(int customerId) {
        if (!rateLimitPerCustomer.containsKey(customerId)) {
            rateLimitPerCustomer.put(customerId, new RateLimitItem(maxRequests, maxSeconds));
        }
        RateLimitItem item = rateLimitPerCustomer.get(customerId);
        return item.allowRequest();
    }

}
