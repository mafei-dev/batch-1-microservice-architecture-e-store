package com.example.orderservice.service.external;

import com.example.orderservice.modal.UserDetailModal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE", path = "/user")
public interface UserService {
    @GetMapping(path = {"/{username}"})
    ResponseEntity<UserDetailModal> getUserDetail(@PathVariable("username") String username);
}
