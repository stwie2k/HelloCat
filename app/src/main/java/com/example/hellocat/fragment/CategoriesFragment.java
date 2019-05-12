package com.example.hellocat.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellocat.contract.MvvmContract;
import com.example.hellocat.R;
import com.example.hellocat.adapter.CategoriesAdapter;
import com.example.hellocat.bean.Categories;
import com.example.hellocat.model.CategoriesModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesFragment extends BaseFragment implements MvvmContract.ILisener2<Categories> {


    @BindView(R.id.categories_recycle)
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        ButterKnife.bind(this,view);

        CategoriesModel.getdata(this);

        return view;
    }

    @Override
    public void loadData(){

    }
    @Override
    public void loadSuccessful(List<Categories> categories){

        CategoriesAdapter adapter = new CategoriesAdapter(getContext(), categories);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);


    }

}
