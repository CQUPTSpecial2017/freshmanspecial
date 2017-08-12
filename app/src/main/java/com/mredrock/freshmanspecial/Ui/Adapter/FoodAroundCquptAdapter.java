package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.BeautyInNear;
import com.mredrock.freshmanspecial.data.LifeInNear;
import com.mredrock.freshmanspecial.data.Cate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class FoodAroundCquptAdapter  extends RecyclerView.Adapter<FoodAroundCquptAdapter.FoodViewHolder>{

    private Context mContext;
    private List<Cate> mFoods = new ArrayList<>();
    private List<BeautyInNear> mBeautyInNears = new ArrayList<>();
    private List<LifeInNear> mDailyLifes = new ArrayList<>();

    private int type;
    private FoodViewHolder mViewHolder;

    public FoodAroundCquptAdapter(Context context) {
        mContext = context;

    }

    public FoodAroundCquptAdapter() {


    }

    public List<Cate> getFoods() {
        return mFoods;
    }

    public void setFoods(List<Cate> foods) {
        mFoods .addAll(foods);
        type = 0;

    }

    public List<BeautyInNear> getBeautyAroundCqupts() {
        return mBeautyInNears;
    }

    public void setBeautyAroundCqupts(List<BeautyInNear> beautyInNears) {
        mBeautyInNears.addAll(beautyInNears);
        type = 1;
    }

    public List<LifeInNear> getDailyLifes() {
        return mDailyLifes;
    }

    public void setDailyLifes(List<LifeInNear> dailyLifes) {

        mDailyLifes.addAll(dailyLifes);
        type = 2;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_surround_cqupt,parent,false);
        mViewHolder = new FoodViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        if (type ==1 ) {
            holder.mBeautyInNear = mBeautyInNears.get(position);
            Glide.with(mContext)
                    .load(holder.mBeautyInNear.getUrl().get(0))
                    .crossFade()
                    .into(holder.image);
            holder.name.setText(holder.mBeautyInNear.getName());
            holder.describe.setText(holder.mBeautyInNear.getResume());
            holder.way.setText(holder.mBeautyInNear.getLocation());


        }else if (type == 0){

            holder.mFood = mFoods.get(position);
            Glide.with(mContext)
                    .load(holder.mFood.getUrl().get(0))
                    .crossFade()
                    .into(holder.image);
            holder.name.setText(holder.mFood.getName());
            holder.describe.setText(holder.mFood.getResume());
            holder.way.setText(holder.mFood.getLocation());

        }else {

            holder.mDailyLife = mDailyLifes.get(position);
            Glide.with(mContext)
                    .load(holder.mDailyLife.getUrl().get(0))
                    .crossFade()
                    .into(holder.image);
            holder.name.setText(holder.mDailyLife.getName());
            holder.describe.setText(holder.mDailyLife.getResume());
            holder.way.setText(holder.mDailyLife.getLocation());

        }

    }


    @Override
    public int getItemCount() {

        if (type == 1)
            return mBeautyInNears.size();
        else if(type ==0)
            return mFoods.size();
        else
            return mDailyLifes.size();
    }




    class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView describe;
        private ImageView image;
        private TextView way;
        private Cate mFood;
        private BeautyInNear mBeautyInNear;
        private LifeInNear mDailyLife;


        public FoodViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_name);
            describe = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_information);
            image = (ImageView) itemView.findViewById(R.id.special_2017_surround_cqupt_image);
            way = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_way);

        }



    }
}

