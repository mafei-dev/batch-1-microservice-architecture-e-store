package com.example.orderservice.tmp;

public class Sleep {
    public static void sleepMe(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
