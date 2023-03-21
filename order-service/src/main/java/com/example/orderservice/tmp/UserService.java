package com.example.orderservice.tmp;

import com.example.orderservice.utl.FallbackMethod;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

@Component
public class UserService {


    @CircuitBreaker(name = "getMyName", fallbackMethod = "getMyNameFallback")
    public String getMyName(String name) {
        System.out.println("UserService:getMyName:Thread:" + Thread.currentThread().getName());
        Sleep.sleepMe(2_000);
//        return name;
        throw new RuntimeException("404");
    }

    @FallbackMethod
    public String getMyNameFallback(String name, Exception exception) {
        System.err.println(exception.getMessage());
        System.out.println("UserService:getMyNameFallback:Thread:" + Thread.currentThread().getName());
        return "i am from fallback method";
    }
}
