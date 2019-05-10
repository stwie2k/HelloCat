package com.example.hellocat.network;


import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.bean.FavouriteCats;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface RemoteService {
    @GET("/v1/breeds")

    Observable<List<Breed>> getBreeds();

    @GET("/v1/breeds/search")

    Observable<List<BreedImage>> searchBreed(@Query("q")  String name);

    @GET("/v1/images/search")

    Observable<List<BreedImage>> getImage(@Query("breed_id")  String breed_id);



    @Headers("x-api-key:992d0a64-e243-4c2e-a800-4c5f2f33d041")
    @GET("/v1/favourites")
    Observable<List<FavouriteCats>> getFavorites();




}