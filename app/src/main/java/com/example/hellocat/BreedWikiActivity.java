package com.example.hellocat;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.hellocat.databinding.ActivityBreedwikiBinding;
import com.example.hellocat.viewModel.WikiViewModel;

public class BreedWikiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityBreedwikiBinding activityBreedwikiBinding= DataBindingUtil.setContentView(this,R.layout.activity_breedwiki);


        Intent intent=getIntent();
        String id=intent.getStringExtra("id");




        activityBreedwikiBinding.setBreedwiki(new WikiViewModel(id));


//        BreedImage



    }

}
