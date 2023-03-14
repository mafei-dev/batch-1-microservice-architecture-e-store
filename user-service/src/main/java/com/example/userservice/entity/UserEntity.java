//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity(
        name = "user"
)
@Table(
        name = "user_detail"
)
public class UserEntity {
    @Id
    @GeneratedValue(
            generator = "uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    private String userId;
    @Column(
            unique = true
    )
    private String username;
    private String tel;
    private String address;
    private int isActive;

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public String getUserId() {
        return this.userId;
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

    public int getIsActive() {
        return this.isActive;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
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

    public void setIsActive(final int isActive) {
        this.isActive = isActive;
    }

    public UserEntity() {
    }

    public UserEntity(final String userId, final String username, final String tel, final String address, final int isActive) {
        this.userId = userId;
        this.username = username;
        this.tel = tel;
        this.address = address;
        this.isActive = isActive;
    }

    public static class UserEntityBuilder {
        private String userId;
        private String username;
        private String tel;
        private String address;
        private int isActive;

        UserEntityBuilder() {
        }

        public UserEntityBuilder userId(final String userId) {
            this.userId = userId;
            return this;
        }

        public UserEntityBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserEntityBuilder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public UserEntityBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public UserEntityBuilder isActive(final int isActive) {
            this.isActive = isActive;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this.userId, this.username, this.tel, this.address, this.isActive);
        }

        public String toString() {
            return "UserEntity.UserEntityBuilder(userId=" + this.userId + ", username=" + this.username + ", tel=" + this.tel + ", address=" + this.address + ", isActive=" + this.isActive + ")";
        }
    }
}
