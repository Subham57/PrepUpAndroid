package com.subham.prepup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String API_BASE_URL = "http://192.168.43.50:8082/";
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }















}

//    public static Retrofit getRetrofit() {
//
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://192.168.43.50:8082/")
//                .client(okHttpClient)
//                .build();
//
////        //        retrofit builder
////        Retrofit retrofit = new Retrofit.Builder()
////                .baseUrl("http://10.17.88.233:8080/BankAPIDemo/")
////                .addConverterFactory(GsonConverterFactory.create())
////                .build();
////        accountApi = retrofit.create(AccountApi.class);
//        return retrofit;
//
//    }
//    public static UserService getService(){
//        UserService userService = getRetrofit().create(UserService.class);
//        return userService;
//    }
//}


//    public static Retrofit getClient(){
//        Retrofit client = null;
//
//
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .connectTimeout(1, TimeUnit.MINUTES)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30,TimeUnit.SECONDS)
//                .build();
//
//        client = new Retrofit.Builder()
//                .baseUrl("http://localhost:8082/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient)
//                .build();
//
//        return client;
//    }

