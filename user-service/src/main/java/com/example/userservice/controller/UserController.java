//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.controller;

import com.example.userservice.dto.NewUserDetailDto;
import com.example.userservice.dto.UserDetailModalDto;
import com.example.userservice.modal.NewUserDetailModal;
import com.example.userservice.modal.UserDetailModal;
import com.example.userservice.service.UserService;

import java.util.Collections;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/user"})
public class UserController {
    private UserService userService;

    @GetMapping(
            path = {"/{username}"}
    )
    public UserDetailModal getUserDetail(@PathVariable("username") String username) {
        UserDetailModalDto userDetail = this.userService.getUserDetail(username);
        return UserDetailModal.builder()
                .isActive(userDetail.getIsActive())
                .userId(userDetail.getUserId())
                .username(userDetail.getUsername())
                .tel(userDetail.getTel())
                .address(userDetail.getAddress())
                .build();
    }

    @PostMapping
    @ResponseStatus(
            code = HttpStatus.CREATED
    )
    public Object addNewUser(HttpEntity<NewUserDetailModal> modalHttpEntity) {
        NewUserDetailModal newUserDetailModal = (NewUserDetailModal) Objects.requireNonNull((NewUserDetailModal) modalHttpEntity.getBody(), "the body is null.");
        this.userService.addNewUser(NewUserDetailDto.builder().username(newUserDetailModal.getUsername()).tel(newUserDetailModal.getTel()).address(newUserDetailModal.getAddress()).build());
        return Collections.singletonMap("msg", "user saved successfully.");
    }

    public UserController(final UserService userService) {
        this.userService = userService;
    }
}
