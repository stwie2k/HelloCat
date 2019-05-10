package com.example.hellocat.model;

import android.util.Log;

import com.example.hellocat.Contract2;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.network.NetworkHelper;
import com.example.hellocat.network.RemoteService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class WikiModel{
    static RemoteService service;
    public static void getdata(final Contract2.ILisener lisener , String id) {


         service= NetworkHelper.getRetrofit().create(RemoteService.class);


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