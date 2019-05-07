package com.example.hellocat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Cantranct.IView{
    MvpPresenter mPresenter;


    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Logger.addLogAdapter(new AndroidLogAdapter());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView=findViewById(R.id.breed_recycler);
        mPresenter = new MvpPresenter(this);

        mPresenter.presenter();


    }

    @Override//从P层获取到的数据  在P层里获取到M层请求的数据
    public void view(List<Breed> data) {
        BreedAdapter adapter = new BreedAdapter(this, data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
}
