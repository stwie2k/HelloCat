package com.example.hellocat;


import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RemoteService {
    @GET("/v1/breeds")

    Observable<List<Breed>> getBreeds();

    @GET("/v1/breeds/search")

    Observable<List<BreedImage>> searchBreed(@Query("q")  String name);

    @GET("/v1/images/search")

    Observable<List<BreedImage>> getImage(@Query("breed_id")  String breed_id);


}