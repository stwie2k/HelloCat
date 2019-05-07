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

    @GET("/v1/images/search")

    Observable<List<BreedImage>> getImage(@Query("breed_id")  String breed_id);



}