package com.example.hellocat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.hellocat.bean.BreedImage;

public class BreedWikiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breedwiki);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");

//        BreedImage



    }

}
