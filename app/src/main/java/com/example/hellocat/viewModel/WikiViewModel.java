package com.example.hellocat.viewModel;

import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;

import com.example.hellocat.Contract2;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.model.WikiModel;

public class WikiViewModel implements Contract2.ILisener<BreedImage> {

    //    IBaseView baseView;
    WikiModel mWikimodel;

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> url = new ObservableField<>();


    BreedImage breedImage;
    private LiveData<BreedImage> projectObservable;

//    @BindingAdapter({"imgUrl"})
//    public static void loadImage(ImageView imageView, String imgUrl){
//        //必须为static方法，否则报错
//        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
//    }


    public WikiViewModel(String id) {


        WikiModel.getdata(this, "beng");

//
//        initViewModel();

    }

    public void initViewModel() {
        this.name.set(breedImage.breeds.get(0).name);

        this.url .set(breedImage.url);

    }

    @Override
    public void loadSuccessful(BreedImage mBreedImage) {
        breedImage = mBreedImage;
        initViewModel();
    }


//    public LiveData<BreedImage> getProjectListObservable() {
//        return projectListObservable;
//    }
}
