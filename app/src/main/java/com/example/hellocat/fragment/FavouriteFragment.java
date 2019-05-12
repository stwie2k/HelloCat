package com.example.hellocat.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellocat.contract.MvpContract;
import com.example.hellocat.adapter.FavouriteAdapter;
import com.example.hellocat.bean.FavouriteCats;
import com.example.hellocat.R;
import com.example.hellocat.presenter.FavouritePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteFragment extends BaseFragment implements MvpContract.IView<FavouriteCats> {
    FavouritePresenter mPresenter;

    @BindView(R.id.favourite_recycle)
    RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        ButterKnife.bind(this,view);

        return view;
    }
    @Override
    public void loadData(){
        mPresenter = new FavouritePresenter(this);
        mPresenter.presenter();
    }
    @Override
    public void view(final List<FavouriteCats> data) {
        FavouriteAdapter adapter = new FavouriteAdapter(getContext(), data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);



    }
}
