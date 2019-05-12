package com.example.hellocat.contract;

import com.example.hellocat.bean.Breed;

import java.util.List;

public class MvpContract {

    public interface IModel {

        void getModel(CallBack callBack);


        interface CallBack <T>{

            void callData(List<T> comics);
        }
    }


    public interface IPresenter {
        void presenter();
    }

    public interface IView <T>{

        void view(List<T> comics);
    }

}
