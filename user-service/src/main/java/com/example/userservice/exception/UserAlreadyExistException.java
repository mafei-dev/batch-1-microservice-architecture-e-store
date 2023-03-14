//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.exception;

public class UserAlreadyExistException extends RuntimeException {
    private final String username;

    public UserAlreadyExistException(String username) {
        this.username = username;
    }

    public UserAlreadyExistException(String message, String username) {
        super(message);
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
