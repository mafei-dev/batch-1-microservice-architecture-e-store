//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.service;

import com.example.userservice.dto.NewUserDetailDto;
import com.example.userservice.dto.UserDetailModalDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.exception.UserAlreadyExistException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDetailModalDto getUserDetail(String username) throws UserNotFoundException {
        return (UserDetailModalDto)this.userRepository.findFirstByUsername(username).map((userEntity) -> {
            UserDetailModalDto dto = new UserDetailModalDto();
            dto.setUserId(userEntity.getUserId());
            dto.setUsername(userEntity.getUsername());
            dto.setAddress(userEntity.getAddress());
            dto.setTel(userEntity.getTel());
            dto.setIsActive(userEntity.getIsActive());
            return dto;
        }).orElseThrow(() -> {
            return new UserNotFoundException(String.format("%s is not found", username), username);
        });
    }

    @Transactional(
            rollbackFor = {UserAlreadyExistException.class}
    )
    public void addNewUser(NewUserDetailDto userDetailModal) throws UserAlreadyExistException {
        this.userRepository.findFirstByUsername(userDetailModal.getUsername()).map((userEntity) -> {
            throw new UserAlreadyExistException(String.format("%s username is already exist.", userEntity.getUsername()), userEntity.getUsername());
        }).orElseGet(() -> {
            return this.userRepository.save(UserEntity.builder().userId((String)null).username(userDetailModal.getUsername()).tel(userDetailModal.getTel()).address(userDetailModal.getAddress()).isActive(1).build());
        });
    }

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
