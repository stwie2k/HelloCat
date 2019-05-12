package com.example.hellocat.model;

import android.util.Log;

import com.example.hellocat.contract.MvpContract;
import com.example.hellocat.DBHelper;
import com.example.hellocat.network.RemoteService;
import com.example.hellocat.bean.FavouriteCats;
import com.example.hellocat.network.NetworkHelper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class FavouriteModel implements MvpContract.IModel{
    List<FavouriteCats> data;
     RemoteService service;
    @Override
    public void getModel(final MvpContract.IModel.CallBack callBack){
        service = NetworkHelper.getRetrofit().create(RemoteService.class);

        service.getFavorites()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())



                .subscribe(new DisposableObserver<List<FavouriteCats>>() {
                    @Override
                    public void onComplete() {



                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());

                        data= DBHelper.getFavourite();
                        callBack.callData(data);

                    }

                    @Override
                    public void onNext(List<FavouriteCats> l) {

                       DBHelper.addFavourite(l);

                        callBack.callData(l);



                    }
                });

    }

}
