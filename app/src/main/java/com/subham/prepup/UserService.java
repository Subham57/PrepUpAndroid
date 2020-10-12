package com.subham.prepup;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("rest/login/")
    Call<LoginResponse> LoginUser(@Body HashMap<String, Object> params);

    @POST("rest/registration/")
    Call<RegisterResponse> SignupUser(@Body HashMap<String, Object> params);
}
