//package com.example.hellocat.presenter;
//
//import com.example.hellocat.Contract;
//import com.example.hellocat.bean.FavouriteCats;
//import com.example.hellocat.model.FavouriteModel;
//
//import java.util.List;
//
//public class FavouritePresenter implements Contract.IPresenter {
//
//    //创建M层对象
//    private FavouriteModel model;
//    //创建V层接口的对象
//    private Contract.IView iView;
//    public FavouritePresenter(Contract.IView iView) {
//
//        this.iView = iView;
//
//        model = new FavouriteModel();
//    }
//    @Override//在这个方法里进行M层和V层的交互
//    public void presenter() {
//        //M层创建保存数据的callback接口对象 这个接口里方法的参数就是数据集合
//        model.model(new Contract.IModel.CallBack<FavouriteCats>() {
//            @Override
//            public void callData(List<FavouriteCats> data) {
//                //然后再用V层接口对象保存数据 在V层里展示出来
//                iView.view(data);
//            }
//        });
//
//    }
//}
