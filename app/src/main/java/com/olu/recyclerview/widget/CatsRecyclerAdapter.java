package com.olu.recyclerview.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.olu.recyclerview.R;
import com.olu.recyclerview.model.Cat;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ovidiu.latcu on 12/4/2014.
 */
public class CatsRecyclerAdapter extends RecyclerView.Adapter<CatsRecyclerAdapter.CatViewHolder> {

    private final List<Cat> cats;
    private final Context context;
    private final LayoutInflater inflater;

    public CatsRecyclerAdapter(Context context, List<Cat> cats) {
        this.context = context;
        this.cats = cats;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CatViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.cat_list_item, viewGroup, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatViewHolder viewHolder, int i) {
        Cat kitten = cats.get(i);

        Picasso.with(context)
                .load(kitten.url)
                .fit()
                .centerCrop()
                .into(viewHolder.catImage);
        viewHolder.catDescription.setText(kitten.description);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {

        ImageView catImage;
        TextView catDescription;

        public CatViewHolder(View itemView) {
            super(itemView);
            this.catImage = (ImageView) itemView.findViewById(R.id.cat_image);
            this.catDescription = (TextView) itemView.findViewById(R.id.cat_description);
        }
    }
}
