package com.example.hellocat.contract;



import java.util.List;

public class MvvmContract {


    public interface ILisener<T> {
        //M层获取请求数据的方法 方法参数为下面的接口对象
        void loadSuccessful(T l);



    }

    public interface ILisener2<T> {
        //M层获取请求数据的方法 方法参数为下面的接口对象
        void loadSuccessful(List<T> l);



    }


    public interface  Imodel{

    }
    public interface IView{

    }

}
