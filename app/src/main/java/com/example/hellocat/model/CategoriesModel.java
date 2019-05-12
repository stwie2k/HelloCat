package com.example.hellocat.model;

import android.util.Log;

import com.example.hellocat.DBHelper;
import com.example.hellocat.contract.MvvmContract;
import com.example.hellocat.bean.Categories;
import com.example.hellocat.network.NetworkHelper;
import com.example.hellocat.network.RemoteService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class CategoriesModel {

    static RemoteService service;
    public static void getdata(final MvvmContract.ILisener2<Categories> lisener ) {


        service= NetworkHelper.getRetrofit().create(RemoteService.class);


        service.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


                .subscribe(new DisposableObserver<List<Categories>>() {
                    @Override
                    public void onComplete() {



                    }

                    @Override
                    public void onError(Throwable e) {

                        lisener.loadSuccessful(DBHelper.getCategories());



                    }

                    @Override
                    public void onNext(List<Categories> l) {


                        DBHelper.addCategories(l);
                        lisener.loadSuccessful(l);




                    }
                });





    }
}
