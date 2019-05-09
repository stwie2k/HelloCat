package com.example.hellocat.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.hellocat.Contract2;
import com.example.hellocat.RemoteService;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.network.NetworkHelper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class WikiModel{
    static RemoteService service;
    public static void getdata(final Contract2.ILisener lisener , String id) {
         final MutableLiveData<BreedImage> data = new MutableLiveData<>();

         service= NetworkHelper.getRetrofit().create(RemoteService.class);

//        service.getImage2(id).enqueue(new Callback<List<BreedImage>>() {
//            @Override
//            public void onResponse(Call<List<BreedImage>> call, Response<List<BreedImage>> response) {
//                data.setValue(response.body().get(0));
//            }
//
//            @Override
//            public void onFailure(Call<List<BreedImage>> call, Throwable t) {
//                // TODO better error handling in part #2 ...
//                data.setValue(null);
//            }
//        });

         service.getImage(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


                .subscribe(new DisposableObserver<List<BreedImage>>() {
                    @Override
                    public void onComplete() {



                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());



                    }

                    @Override
                    public void onNext(List<BreedImage> l) {

                        lisener.loadSuccessful(l.get(0));


                    }
                });





    }
}
