package com.example.hellocat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellocat.R;

import butterknife.ButterKnife;

public class CategoriesFragment extends BaseFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void loadData(){

    }

}
