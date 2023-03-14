//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.util;

public class ErrorResponse {
    private String errorMsg;
    private String errorCode;

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponse(final String errorMsg, final String errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public ErrorResponse() {
    }

    public static class ErrorResponseBuilder {
        private String errorMsg;
        private String errorCode;

        ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder errorMsg(final String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public ErrorResponseBuilder errorCode(final String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.errorMsg, this.errorCode);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(errorMsg=" + this.errorMsg + ", errorCode=" + this.errorCode + ")";
        }
    }
}
