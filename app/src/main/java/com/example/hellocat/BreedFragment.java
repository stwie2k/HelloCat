package com.example.hellocat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BreedFragment extends BaseFragment implements Contract.IView{
    MvpPresenter mPresenter;


    private RecyclerView mRecyclerView;

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_breed, container, false);
        mRecyclerView=view.findViewById(R.id.breed_recycler);


        return view;
    }
    @Override
    public void loadData(){
        mPresenter = new MvpPresenter(this);
        mPresenter.presenter();
    }
    @Override//从P层获取到的数据  在P层里获取到M层请求的数据
    public void view(List<Breed> data) {
        BreedAdapter adapter = new BreedAdapter(getContext(), data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);

    }
}
