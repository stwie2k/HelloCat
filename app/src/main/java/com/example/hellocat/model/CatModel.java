package com.example.hellocat.model;

import android.util.Log;

import com.example.hellocat.Contract;
import com.example.hellocat.DBHelper;
import com.example.hellocat.RemoteService;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.network.NetworkHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class CatModel implements Contract.IModel {
    Observable<List<Breed>> observable1;
    Observable<BreedImage> observable2;
    List<Breed> data;
    RemoteService service;
    int index;
    Map<Integer,Breed> map=new HashMap();
    @Override
    public void getModel(final CallBack callBack){


         service = NetworkHelper.getRetrofit().create(RemoteService.class);


//        service.getBreeds()//这里模拟请求数据集合
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//
//                .flatMap(new Function<List<Breed>, ObservableSource<Breed>>() {
//                    @Override
//                    public ObservableSource<Breed> apply(@NonNull List<Breed> l) throws Exception {
//                       index = 0;
//                        return Observable.fromIterable(l);
//                    }
//                })
//                //单独处理每个数据
//                .map(new Function<Breed, String>() {
//                    @Override
//                    public String apply(@NonNull Breed b) throws Exception {
//                        //这里需要使用map来绑定对象跟key key可以使用integer
//                        map.put(index, b);
//                        return b.getName();
//                    }
//                })
//                .observeOn(Schedulers.io())
//                .flatMap(new Function<String, ObservableSource<List<BreedImage>>>() {
//                    @Override
//                    public ObservableSource<List<BreedImage>> apply(@NonNull String ps) throws Exception {
//                        //这边处理url 应该是请求接口B 我这就简单点处理了
//                        ObservableSource<List<BreedImage>> o=service.getImage(ps);
//                        return o;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//
//                .subscribe(new DisposableObserver<List<BreedImage>>() {
//                    @Override
//                    public void onComplete() {
//
//
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<BreedImage> l) {
//
//                        for (BreedImage v : l) {
//
//                        }
//                    }
//
//
//
//
//
//
//
//
//                });



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
