package com.example.hellocat.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    public static Retrofit getRetrofit(){
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .build();

        String baseURL="https://api.thecatapi.com";

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(baseURL)

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .client(build)

                .build();
        return retrofit;

    }
}
