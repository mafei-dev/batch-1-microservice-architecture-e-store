//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.modal;

public class NewUserDetailModal {
    private String username;
    private String tel;
    private String address;

    public static NewUserDetailModalBuilder builder() {
        return new NewUserDetailModalBuilder();
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

    public NewUserDetailModal(final String username, final String tel, final String address) {
        this.username = username;
        this.tel = tel;
        this.address = address;
    }

    public NewUserDetailModal() {
    }

    public static class NewUserDetailModalBuilder {
        private String username;
        private String tel;
        private String address;

        NewUserDetailModalBuilder() {
        }

        public NewUserDetailModalBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public NewUserDetailModalBuilder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public NewUserDetailModalBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public NewUserDetailModal build() {
            return new NewUserDetailModal(this.username, this.tel, this.address);
        }

        public String toString() {
            return "NewUserDetailModal.NewUserDetailModalBuilder(username=" + this.username + ", tel=" + this.tel + ", address=" + this.address + ")";
        }
    }
}
