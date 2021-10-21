package com.example.calorilin.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static  final String BASE_URL = "http://127.0.0.1:8000/api/";

    private static Retrofit retrofit1;

    public static Retrofit getClient() {

        if (retrofit1 == null)
            retrofit1 = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit1;
    }
}
