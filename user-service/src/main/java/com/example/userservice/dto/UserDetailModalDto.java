//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailModalDto {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("is_active")
    private int isActive;
    private String username;
    private String tel;
    private String address;

    public static UserDetailModalDtoBuilder builder() {
        return new UserDetailModalDtoBuilder();
    }

    public UserDetailModalDto(final String userId, final int isActive, final String username, final String tel, final String address) {
        this.userId = userId;
        this.isActive = isActive;
        this.username = username;
        this.tel = tel;
        this.address = address;
    }

    public UserDetailModalDto() {
    }

    public String getUserId() {
        return this.userId;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public String getUsername() {
        return this.username;
    }

    public String getTel() {
        return this.tel;
    }

    public String getAddress() {
        return this.address;
    }

    @JsonProperty("user_id")
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @JsonProperty("is_active")
    public void setIsActive(final int isActive) {
        this.isActive = isActive;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public static class UserDetailModalDtoBuilder {
        private String userId;
        private int isActive;
        private String username;
        private String tel;
        private String address;

        UserDetailModalDtoBuilder() {
        }

        @JsonProperty("user_id")
        public UserDetailModalDtoBuilder userId(final String userId) {
            this.userId = userId;
            return this;
        }

        @JsonProperty("is_active")
        public UserDetailModalDtoBuilder isActive(final int isActive) {
            this.isActive = isActive;
            return this;
        }

        public UserDetailModalDtoBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserDetailModalDtoBuilder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public UserDetailModalDtoBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public UserDetailModalDto build() {
            return new UserDetailModalDto(this.userId, this.isActive, this.username, this.tel, this.address);
        }

        public String toString() {
            return "UserDetailModalDto.UserDetailModalDtoBuilder(userId=" + this.userId + ", isActive=" + this.isActive + ", username=" + this.username + ", tel=" + this.tel + ", address=" + this.address + ")";
        }
    }
}
