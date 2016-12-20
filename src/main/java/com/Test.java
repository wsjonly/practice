package com;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by shijinweng on 16/10/27.
 */
public class Test {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(300);
        for (int i = 0; i < 3000; i++) {
            rateLimiter.acquire();
            System.out.println(i);
        }
    }
}
