package com.subham.prepup;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    public Integer status_code;
    public String message;
    public UserDetails userDetails;

    public LoginResponse() {
        super();
    }

    public LoginResponse(Integer status_code, String message, UserDetails userDetails) {
        this.status_code = status_code;
        this.message = message;
        this.userDetails = userDetails;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
