package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.BeautyAroundCqupt;
import com.mredrock.freshmanspecial.data.DailyLife;
import com.mredrock.freshmanspecial.data.FoodAroundCqupt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class FoodAroundCquptAdapter  extends RecyclerView.Adapter<FoodAroundCquptAdapter.FoodViewHolder>{

    private Context mContext;
    private List<FoodAroundCqupt> mFoods = new ArrayList<>();
    private List<BeautyAroundCqupt> mBeautyAroundCqupts = new ArrayList<>();
    private List<DailyLife> mDailyLifes = new ArrayList<>();

    private int type;
    private FoodViewHolder mViewHolder;

    public FoodAroundCquptAdapter(Context context) {
        mContext = context;

    }

    public FoodAroundCquptAdapter() {


    }

    public List<FoodAroundCqupt> getFoods() {
        return mFoods;
    }

    public void setFoods(List<FoodAroundCqupt> foods) {
        mFoods .addAll(foods);
        type = 0;

    }

    public List<BeautyAroundCqupt> getBeautyAroundCqupts() {
        return mBeautyAroundCqupts;
    }

    public void setBeautyAroundCqupts(List<BeautyAroundCqupt> beautyAroundCqupts) {
        mBeautyAroundCqupts .addAll(beautyAroundCqupts);
        type = 1;
    }

    public List<DailyLife> getDailyLifes() {
        return mDailyLifes;
    }

    public void setDailyLifes(List<DailyLife> dailyLifes) {
        mDailyLifes = dailyLifes;
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
            holder.mBeautyAroundCqupt = mBeautyAroundCqupts.get(position);
            holder.name.setText(holder.mBeautyAroundCqupt.getName());
            holder.describe.setText(holder.mBeautyAroundCqupt.getResume());
            holder.way.setText(holder.mBeautyAroundCqupt.getLocation());


        }else if (type == 0){
            holder.mFood = mFoods.get(position);
            holder.name.setText(holder.mFood.getName());
            holder.describe.setText(holder.mFood.getResume());
            holder.way.setText(holder.mFood.getLocation());

        }else {
            holder.mDailyLife = mDailyLifes.get(position);
            holder.name.setText(holder.mDailyLife.getName());
            holder.describe.setText(holder.mDailyLife.getResume());
            holder.way.setText(holder.mDailyLife.getLocation());

        }

    }


    @Override
    public int getItemCount() {

        if (type == 1)
            return mBeautyAroundCqupts.size();
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
        private FoodAroundCqupt mFood;
        private BeautyAroundCqupt mBeautyAroundCqupt;
        private DailyLife mDailyLife;


        public FoodViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_name);
            describe = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_information);
            image = (ImageView) itemView.findViewById(R.id.special_2017_surround_cqupt_image);
            way = (TextView) itemView.findViewById(R.id.special_2017_surround_cqupt_way);

        }



    }
}

