//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.exception;

public class UserNotFoundException extends RuntimeException {
    private final String username;

    public UserNotFoundException(String username) {
        this.username = username;
    }

    public UserNotFoundException(String message, String username) {
        super(message);
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
