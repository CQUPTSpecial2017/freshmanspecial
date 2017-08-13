package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Special_2017_BeautyImageClickActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/13 0013.
 */

public class TrainingImageAdapter extends RecyclerView.Adapter<TrainingImageAdapter.ImageClickViewHolder> {
    private Context mContext;
    private List<String> mUrls = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    private ImageClickViewHolder mViewHolder ;

    public List<String> getUrls() {
        return mUrls;
    }

    public void setUrls(List<String> urls) {
        mUrls = urls;
    }

    public TrainingImageAdapter() {
    }

    public TrainingImageAdapter(Context context) {

        mContext = context;
    }

    @Override
    public ImageClickViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training_image,parent,false);
        mViewHolder = new TrainingImageAdapter.ImageClickViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageClickViewHolder holder, int position) {
        holder.url = mUrls.get(position);
        Glide.with(mContext)
                .load(holder.url)
                .crossFade()
                .into(holder.image);
        holder.name = names.get(position);
        holder.content.setText(holder.name);
    }

    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    class ImageClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        String url ;
        String name ;
        ImageView image;
        TextView content ;
        public ImageClickViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.item_training_image_image);
            content =(TextView)itemView.findViewById(R.id.item_training_image_name);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Special_2017_BeautyImageClickActivity.class);

            intent.putExtra("type","training");
            intent.putExtra("length",mUrls.size());
            for (int i = 0; i <mUrls.size() ; i++) {
                intent.putExtra(i+"url",mUrls.get(i));
                intent.putExtra(i+"name",names.get(i));
            }
            mContext.startActivity(intent);
        }
    }
}
