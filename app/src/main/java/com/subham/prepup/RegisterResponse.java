package com.subham.prepup;

public class RegisterResponse {

    public int status_code;
    public String message;

    public RegisterResponse() { super(); }

    public RegisterResponse(int status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
