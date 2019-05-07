package com.example.hellocat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHodel> {
    private Context context;
    private List<Breed> data ;

    public BreedAdapter(Context context, List<Breed> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_breed, null);
        return new ViewHodel(view);
    }


    @Override
    public void onBindViewHolder(ViewHodel holder, int position) {
//        Glide.with(context).load(data.get(position).getCover_image_url()).into(holder.im);
        holder.tv.setText(data.get(position).name);
    }

    @Override
    public int getItemCount() {
        return data.size() != 0 ? data.size() : 0;
    }

    static class ViewHodel extends RecyclerView.ViewHolder {

        public final TextView tv;

        public ViewHodel(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);

        }
    }

}
