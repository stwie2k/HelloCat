package com.example.hellocat.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.hellocat.Contract2;
import com.example.hellocat.Model.WikiModel;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;

import java.util.List;

public class WikiViewModel extends AndroidViewModel implements Contract2.ILisener {

//    IBaseView baseView;
    WikiModel mWikimodel;
//    CatFavoritesAdapter adapter;
    public WikiViewModel(Application application) {
        super(application);

        mWikimodel=new WikiModel();


    }

    public void loadData(){
        mWikimodel.getdata(this);

    }
    @Override
    public void loadSuccessful(List l){

    }



//    public LiveData<BreedImage> getProjectListObservable() {
//        return projectListObservable;
//    }
}
