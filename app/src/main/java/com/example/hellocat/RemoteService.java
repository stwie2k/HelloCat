package com.example.hellocat;


import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RemoteService {
    @GET("/v1/breeds")

    Observable<List<Breed>> getBreeds();

    @GET("/users/{user_name}/repos")
        // 这里的List<Repo>即为最终返回的类型，需要保持一致才可解析
        // 之所以使用一个List包裹是因为该接口返回的最外层是一个数组
        //Call<List<Repo>> getRepo(@Path("user_name") String user_name);
        // 特别地，使用rxJava时为
    Observable<List<Breed>> getRepo(@Path("user_name") String user_name);



}