package org.example;

public class RateLimitItem {
    private int currRequests = 0;
    private long startTimestamp = 0;
    private final long maxSeconds;
    private final int maxRequests;

    RateLimitItem(int maxRequests, int maxSeconds) {
        this.maxRequests = maxRequests;
        this.maxSeconds = maxSeconds * 1000;    // convert to milliseconds
    }

    boolean allowRequest() {
        long currentTimestamp = getCurrentTimeStamp();
        long remainingTime = currentTimestamp - startTimestamp;
        if (remainingTime > maxSeconds) {
            resetTimeBucket(currentTimestamp);
        } else {
            if ((maxRequests - currRequests) < 1) {
                return false;
            }
            currRequests += 1;
        }
        return true;
    }

    private void resetTimeBucket(long currentTimestamp) {
        currRequests = 1; // since this is a request
        startTimestamp = currentTimestamp;
    }

    /**
     * @return current timestamp
     */
    private long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

}
