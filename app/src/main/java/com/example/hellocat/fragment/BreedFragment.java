package com.example.hellocat.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellocat.Breed;
import com.example.hellocat.Contract;
import com.example.hellocat.MvpPresenter;
import com.example.hellocat.R;
import com.example.hellocat.adapter.BreedAdapter;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreedFragment extends BaseFragment implements Contract.IView{
    MvpPresenter mPresenter;




    @BindView(R.id.breed_recycler)
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_breed, container, false);

        ButterKnife.bind(this,view);

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