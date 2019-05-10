package com.example.hellocat.viewModel;

import android.arch.lifecycle.LiveData;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hellocat.Contract2;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.model.WikiModel;

public class WikiViewModel implements Contract2.ILisener<BreedImage> {

    WikiModel mWikimodel;

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> url = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();

    BreedImage breedImage;


    @BindingAdapter({"url"})
    public static void loadImage(ImageView imageView, String imgUrl){

        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }


    public WikiViewModel(String id) {


        WikiModel.getdata(this, id);


    }

    public void initViewModel() {
        this.name.set(breedImage.breeds.get(0).name);

        this.url .set(breedImage.url);

        this.description.set(breedImage.breeds.get(0).description);

    }

    @Override
    public void loadSuccessful(BreedImage mBreedImage) {
        breedImage = mBreedImage;
        initViewModel();
    }


}
