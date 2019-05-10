package com.example.hellocat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hellocat.R;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.FavouriteCats;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHodel> {

    private Context context;
    private List<FavouriteCats> data ;
    private FavouriteAdapter.OnItemClickListener mClickListener;

    public FavouriteAdapter(Context context, List<FavouriteCats> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public FavouriteAdapter.ViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_favourite, null);
        return new FavouriteAdapter.ViewHodel(view);
    }


    @Override
    public void onBindViewHolder(FavouriteAdapter.ViewHodel holder, final int position) {
        Glide.with(context)
                .load(data.get(position).getImage().getUrl())
                .into(holder.iv);
        holder.tv.setText(String.valueOf(data.get(position).getId()));

        if (mClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size() != 0 ? data.size() : 0;
    }

    public interface OnItemClickListener {
        public void onItemClick(int postion);
    }

    public void setOnItemClickListener(FavouriteAdapter.OnItemClickListener listener) {
        this.mClickListener = listener;
    }

    static class ViewHodel extends RecyclerView.ViewHolder {

        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.iv)
        ImageView iv;


        public ViewHodel(View itemView) {
            super(itemView);


            ButterKnife.bind(this,itemView);

        }
    }
}
