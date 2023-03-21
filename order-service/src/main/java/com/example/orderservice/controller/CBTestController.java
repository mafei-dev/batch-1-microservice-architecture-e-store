package com.example.orderservice.controller;

import com.example.orderservice.tmp.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/cb")
@AllArgsConstructor
public class CBTestController {


    private final UserService userService;

    @GetMapping
    public Map<String, String> testCB() {
        System.out.println("CBTestController:testCB:Thread:" + Thread.currentThread().getName());
        return
                Collections.singletonMap(
                        "name",
                        this.userService.getMyName(Thread.currentThread().getName())
                );
    }

    public Map<String, String> testCBFallback(Exception exception) {
        System.out.println("CBTestController:testCBFallback:Thread:" + Thread.currentThread().getName());
        return Collections.singletonMap(
                "name",
                exception.getMessage() + ":" + exception.getClass().getSimpleName()
        );
    }
}
