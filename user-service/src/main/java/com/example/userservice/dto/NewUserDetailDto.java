//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.dto;

public class NewUserDetailDto {
    private String username;
    private String tel;
    private String address;

    NewUserDetailDto(final String username, final String tel, final String address) {
        this.username = username;
        this.tel = tel;
        this.address = address;
    }

    public static NewUserDetailDtoBuilder builder() {
        return new NewUserDetailDtoBuilder();
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

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public static class NewUserDetailDtoBuilder {
        private String username;
        private String tel;
        private String address;

        NewUserDetailDtoBuilder() {
        }

        public NewUserDetailDtoBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public NewUserDetailDtoBuilder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public NewUserDetailDtoBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public NewUserDetailDto build() {
            return new NewUserDetailDto(this.username, this.tel, this.address);
        }

        public String toString() {
            return "NewUserDetailDto.NewUserDetailDtoBuilder(username=" + this.username + ", tel=" + this.tel + ", address=" + this.address + ")";
        }
    }
}
