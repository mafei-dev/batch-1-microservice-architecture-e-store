//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.schedule;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private static final Logger log = LoggerFactory.getLogger(EmailSender.class);

    public EmailSender() {
    }

    @Scheduled(
            fixedRate = 5000L
    )
    @Async
    public void reportCurrentTime() {
        log.info("The time is now {}", LocalDateTime.now());
    }
}
