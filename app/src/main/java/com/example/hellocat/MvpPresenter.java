package com.example.hellocat;


import com.example.hellocat.bean.Breed;

import java.util.List;

public class MvpPresenter implements Contract.IPresenter {
    //创建M层对象
    private CatModel model;
    //创建V层接口的对象
    private Contract.IView iView;

    //构造方法的参数为V层的接口对象
    public MvpPresenter(Contract.IView iView) {
        //待会展示数据的类实现V接口 创建P层的时候 将本身传进来 也就是说P层和展示数据的类他俩使用的是共同的一个V层接口 自然这个V层接口方法里的数据就可以共用了
        this.iView = iView;
        //创建M层的时候自然运行M层实现的请求数据方法 现在可以理解为已经请求到了数据
        model = new CatModel();
    }

    @Override//在这个方法里进行M层和V层的交互
    public void presenter() {
        //M层创建保存数据的callback接口对象 这个接口里方法的参数就是数据集合
        model.model(new Contract.IModel.CallBack() {
            @Override
            public void callData(List<Breed> data) {
                //然后再用V层接口对象保存数据 在V层里展示出来
                iView.view(data);
            }
        });

    }


    public void getData(){


    }

}
