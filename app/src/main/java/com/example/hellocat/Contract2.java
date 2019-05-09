package com.example.hellocat;

import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;

import java.util.List;

public class Contract2 {


    public interface ILisener<T> {
        //M层获取请求数据的方法 方法参数为下面的接口对象
        void loadSuccessful(List<T> l);


    }

    public interface  Imodel{

    }
    public interface IView{}

}
