package com.example.first;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class retrofitInterface {
    @POST("/login")
    Call< registerResult > executeLogin(@Body HashMap<String, String> map) {
        return null;
    }
    @POST("/signup")
    Call<Void> executeSignup(@Body HashMap<String, String> map){
           return null;
    }
}
