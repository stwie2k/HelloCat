package com.example.hellocat;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.hellocat.databinding.ActivityBreedWikiBinding;
import com.example.hellocat.viewModel.WikiViewModel;

public class BreedWikiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityBreedWikiBinding activityBreedwikiBinding= DataBindingUtil.setContentView(this,R.layout.activity_breed_wiki);


        Intent intent=getIntent();
        String id=intent.getStringExtra("id");


        activityBreedwikiBinding.setBreedwiki(new WikiViewModel(id));





    }

}
