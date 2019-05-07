package com.example.hellocat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatModel implements Contract.IModel {
    Observable<List<Breed>> observable1;
    Observable<BreedImage> observable2;
    List<Breed> data;
    RemoteService service;
    public void model(final CallBack callBack){
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .build();

        String baseURL="https://api.thecatapi.com";

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(baseURL)

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .client(build)

                .build();


         service = retrofit.create(RemoteService.class);




        service.getBreeds()
//                .flatMap(new Func1<String, Observable<User>>() {  //得到token后获取用户信息
//                    @Override
//                    public Observable<User> onNext(String token) {
//                        return service.getImage(token);
//                    })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(new Action1<List<Breed>>() {
//                    @Override
//                    public void call(List<Breed> l) {
//                        saveUserInfo(l);//保存用户信息到本地
//                    }
//                })
//
//
//               .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
//                .subscribe(new Subscriber<List<Breed>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //请求失败
//                    }
//
//                    @Override
//                    public void onNext(UserInfo userInfo) {
//                        //请求成功
//                        callBack.callData(l);
//                    }
//                });


                .subscribe(new DisposableObserver<List<Breed>>() {
                    @Override
                    public void onComplete() {



                    }

                    @Override
                    public void onError(Throwable e) {

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
                                callBack.callData(data);
                            }







                        }
                    });
        }
    }



}
