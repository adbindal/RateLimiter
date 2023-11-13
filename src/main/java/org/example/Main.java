package org.example;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 10);
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // true
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // true
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // true
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // true
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // true
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // false
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // false
        System.out.println("customerId: 1, allowed: " + rateLimiter.rateLimit(1));   // false
        System.out.println("customerId: 2, allowed: " + rateLimiter.rateLimit(2));   // true
    }
}