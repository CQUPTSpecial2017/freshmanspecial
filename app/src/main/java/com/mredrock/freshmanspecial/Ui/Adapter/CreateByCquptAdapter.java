package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.ExcellentTech;
import com.mredrock.freshmanspecial.data.NatureCQUPT;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/13 0013.
 */

public class CreateByCquptAdapter extends RecyclerView.Adapter<CreateByCquptAdapter.CreateByCquptViewHolder> {
    private ArrayList<NatureCQUPT> mCreates = new ArrayList<>();
    private CreateByCquptViewHolder mViewHolder ;
    private ArrayList<ExcellentTech> mTeches = new ArrayList<>();
    private int type;
    private Context mContext;

    public CreateByCquptAdapter(Context context) {
        mContext = context;
    }

    public CreateByCquptAdapter() {
    }

    public ArrayList<NatureCQUPT> getCreates() {
        return mCreates;
    }

    public void setCreates(ArrayList<NatureCQUPT> creates) {
        mCreates = creates;
        type = 0;
    }

    public ArrayList<ExcellentTech> getTeches() {
        return mTeches;
    }

    public void setTeches(ArrayList<ExcellentTech> teches) {
        mTeches = teches;
        type = 1;
    }

    @Override
    public CreateByCquptViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_create_by_cqupt,parent,false);
        mViewHolder = new CreateByCquptViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(CreateByCquptViewHolder holder, final int position) {

        if (type == 1) {
            holder.mExcellentTech = mTeches.get(position);
            holder.name.setText(holder.mExcellentTech.getName());
            holder.name.setTextColor(Color.parseColor("#333333"));
            Glide.with(mContext)
                    .load(holder.mExcellentTech.getUrl())
                    .crossFade()
                    .into(holder.mImageView);
        }

           else if (type == 0) {
            holder.mCQUPT = mCreates.get(position);
            holder.name.setText(holder.mCQUPT.getName());
            holder.name.setTextColor(Color.parseColor("#333333"));
            holder.name.setGravity(Gravity.LEFT);
            Glide.with(mContext)
                   .load(holder.mCQUPT.getCover())
                   .crossFade()
                   .into(holder.mImageView);

            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(mCreates.get(position).getUrl());
                    intent.setData(content_url);
                    intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                    mContext.startActivity(intent);
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        switch (type){
            case 0:
                return mCreates.size();
            case 1:
                return mTeches.size();
            default:
                return 0;
        }

    }
    class CreateByCquptViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView name;
        ExcellentTech mExcellentTech;
        NatureCQUPT mCQUPT;
        public CreateByCquptViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.special_2017_create_by_cqupt_image);
            name = (TextView) itemView.findViewById(R.id.special_2017_create_by_cqupt_name);

        }
    }
}
