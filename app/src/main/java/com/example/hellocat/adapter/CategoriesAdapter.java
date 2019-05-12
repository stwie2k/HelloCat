package com.example.hellocat.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellocat.R;
import com.example.hellocat.bean.Categories;
import com.example.hellocat.databinding.ItemCategoriesBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<Categories> categoriesList;
    Context context;
    public CategoriesAdapter(Context context,List<Categories> mDatas) {
        this.context=context;
        this.categoriesList = mDatas;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCategoriesBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_categories, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Categories categories=categoriesList.get(position);

        holder.getBinding().setCategory(categories);
        holder.getBinding().executePendingBindings();




    }

    @Override
    public int getItemCount() {
        return categoriesList == null ? 0 : categoriesList.size();

    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCategoriesBinding binding;

        public ItemCategoriesBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemCategoriesBinding binding) {
            this.binding = binding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
