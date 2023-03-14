//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailModal {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("is_active")
    private int isActive;
    private String username;
    private String tel;
    private String address;

    public static UserDetailModalBuilder builder() {
        return new UserDetailModalBuilder();
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

    public UserDetailModal(final String userId, final int isActive, final String username, final String tel, final String address) {
        this.userId = userId;
        this.isActive = isActive;
        this.username = username;
        this.tel = tel;
        this.address = address;
    }

    public UserDetailModal() {
    }

    public static class UserDetailModalBuilder {
        private String userId;
        private int isActive;
        private String username;
        private String tel;
        private String address;

        UserDetailModalBuilder() {
        }

        @JsonProperty("user_id")
        public UserDetailModalBuilder userId(final String userId) {
            this.userId = userId;
            return this;
        }

        @JsonProperty("is_active")
        public UserDetailModalBuilder isActive(final int isActive) {
            this.isActive = isActive;
            return this;
        }

        public UserDetailModalBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserDetailModalBuilder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public UserDetailModalBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public UserDetailModal build() {
            return new UserDetailModal(this.userId, this.isActive, this.username, this.tel, this.address);
        }

        public String toString() {
            return "UserDetailModal.UserDetailModalBuilder(userId=" + this.userId + ", isActive=" + this.isActive + ", username=" + this.username + ", tel=" + this.tel + ", address=" + this.address + ")";
        }
    }
}
