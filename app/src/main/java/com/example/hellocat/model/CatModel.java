package com.example.hellocat.model;

import android.util.Log;

import com.example.hellocat.contract.MvpContract;
import com.example.hellocat.DBHelper;
import com.example.hellocat.network.RemoteService;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.network.NetworkHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class CatModel implements MvpContract.IModel {

    List<Breed> data;
    RemoteService service;
    int index;
    Map<Integer,Breed> map=new HashMap();
    @Override
    public void getModel(final CallBack callBack){


         service = NetworkHelper.getRetrofit().create(RemoteService.class);






        service.getBreeds()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())



                .subscribe(new DisposableObserver<List<Breed>>() {
                    @Override
                    public void onComplete() {



                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());

                        data= DBHelper.getBreeds();
                        callBack.callData(data);

                    }

                    @Override
                    public void onNext(List<Breed> l) {

                        data=l;

                        getimage(callBack);





                    }
                });






    }
    public void getimage(final CallBack callBack){

        for(int i=0;i<data.size();i++){
            final int index=i;
            service.getImage(data.get(i).getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<List<BreedImage>>() {
                        @Override
                        public void onComplete() {



                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<BreedImage> l) {

                            BreedImage b=l.get(0);
                            data.get(index).setImg_url(b.url);



                            if(index==data.size()-1){
                                DBHelper.addBreed(data);
                                callBack.callData(data);
                            }







                        }
                    });
        }
    }



}
