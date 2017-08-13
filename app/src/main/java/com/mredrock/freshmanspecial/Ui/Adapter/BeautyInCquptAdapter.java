package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Special_2017_BeautyImageClickActivity;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.Canteen;
import com.mredrock.freshmanspecial.data.Dormitory;
import com.mredrock.freshmanspecial.data.SchoolBuilding;
import com.mredrock.freshmanspecial.httptools.DataAboutFresh;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class BeautyInCquptAdapter extends RecyclerView.Adapter<BeautyInCquptAdapter.BeautyHolder> {

    private Context mContext;
    //type = 0 学校宿舍 , type = 1 学校食堂 , type = 2 美在重邮 , type = 3 学校环境
    private int type;
    private ArrayList<Dormitory> mDormitories = new ArrayList<>();
    private ArrayList<Canteen> mCanteens = new ArrayList<>();
    private ArrayList<com.mredrock.freshmanspecial.data.BeautyInCqupt> mBeautyInCqupts = new ArrayList<>();
    private ArrayList<SchoolBuilding> mEnvironments = new ArrayList<>();

    private BeautyInCquptAdapter.BeautyHolder mViewHolder;

    public BeautyInCquptAdapter(Context context) {
        mContext = context;

    }

    public BeautyInCquptAdapter() {


    }

    public ArrayList<BeautyInCqupt> getBeautyInCqupts() {
        return mBeautyInCqupts;
    }

    public void setBeautyInCqupts(ArrayList<BeautyInCqupt> beautyInCqupts) {
        mBeautyInCqupts = beautyInCqupts;
        type = 2;
    }

    public ArrayList<Dormitory> getDormitories() {
        return mDormitories;
    }

    public void setDormitories(ArrayList<Dormitory> dormitories) {
        mDormitories = dormitories;
        type = 0;
    }

    public ArrayList<Canteen> getCanteens() {
        return mCanteens;
    }

    public void setCanteens(ArrayList<Canteen> canteens) {
        mCanteens = canteens;
        type = 1;
    }

    public ArrayList<SchoolBuilding> getEnvironments() {

        return mEnvironments;
    }

    public void setEnvironments(ArrayList<SchoolBuilding> environments) {

        mEnvironments = environments;
        type = 3;
    }

    @Override
    public BeautyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_beauty_in_cqupt,parent,false);
        mViewHolder = new BeautyHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(BeautyHolder holder, int position) {
        switch (type){
            case 0:
                holder.mDormitory = mDormitories.get(position);
                holder.title.setText(holder.mDormitory.getName());
                holder.information.setText(holder.mDormitory.getResume());
                holder.image.setScaleType(ImageView.ScaleType.CENTER);
                Glide.with(mContext)
                        .load(holder.mDormitory.getUrl().get(0))
                        .crossFade()
                        .into(holder.image);

                holder.mCountLayout.setVisibility(View.VISIBLE);
                holder.mCount.setText(holder.mDormitory.getUrl().size()+"张");
                holder.count = holder.mDormitory.getUrl().size();
                break;
            case 1:
                holder.mCanteen = mCanteens.get(position);
                holder.title.setText(holder.mCanteen.getName());
                holder.information.setText(holder.mCanteen.getResume());
                holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(mContext)
                        .load(holder.mCanteen.getUrl().get(0))
                        .crossFade()
                        .into(holder.image);

                holder.mCountLayout.setVisibility(View.VISIBLE);
                holder.mCount.setText(holder.mCanteen.getUrl().size()+"张");
                holder.count = holder.mCanteen.getUrl().size();
                break;
            case 2:
                holder.mBeautyInCqupt = mBeautyInCqupts.get(position);
                holder.title.setText(holder.mBeautyInCqupt.getTitle());
                holder.information.setText(holder.mBeautyInCqupt.getContent());
                holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(mContext)
                        .load(holder.mBeautyInCqupt.getUrl())
                        .crossFade()
                        .into(holder.image);

                holder.mCountLayout.setVisibility(View.GONE);
                break;
            case 3:
                holder.mEnvironment = mEnvironments.get(position);
                holder.title.setText(holder.mEnvironment.getTitle());
                holder.information.setText(holder.mEnvironment.getContent());
                holder.image.setScaleType(ImageView.ScaleType.CENTER);
                Glide.with(mContext)
                        .load(holder.mEnvironment.getUrl().get(0))
                        .crossFade()
                        .into(holder.image);

                holder.mCountLayout.setVisibility(View.GONE);
                break;

        }



    }


    @Override
    public int getItemCount() {

        switch (type){
            case 0:
                return mDormitories.size();
            case 1:
                return mCanteens.size();
            case 2:
                return mBeautyInCqupts.size();
            case 3:
                return mEnvironments.size();
            default:
                return 0;
        }

    }




    class BeautyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView information;
        private ImageView image;
        private int count;
        private RelativeLayout mCountLayout;
        private TextView mCount;
        private BeautyInCqupt mBeautyInCqupt;
        private Dormitory mDormitory;
        private Canteen mCanteen;
        private SchoolBuilding mEnvironment;


        public BeautyHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_beauty_in_cqupt_title);
            title.setTextColor(Color.parseColor("#666666"));
            information = (TextView) itemView.findViewById(R.id.item_beauty_in_cqupt_information);
            information.setTextColor(Color.parseColor("#999999"));
            image = (ImageView) itemView.findViewById(R.id.item_beauty_in_cqupt_image);
            mCountLayout = (RelativeLayout)itemView.findViewById(R.id.item_beauty_in_cqupt_count);
            mCount = (TextView)itemView.findViewById(R.id.item_beauty_in_cqupt_count_text);
            if (type <= 1){
                itemView.setOnClickListener(this);
            }

        }


        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Special_2017_BeautyImageClickActivity.class);
            switch (type){
                case 0:
                    intent.putExtra("type","dormitory");
                    intent.putExtra("length",count);
                    intent.putExtra("dormitory",mDormitory);

                    break;
                case 1:
                    intent.putExtra("type","canteen");
                    intent.putExtra("length",count);
                    intent.putExtra("canteen",mCanteen);
                    break;

            }
            view.getContext().startActivity(intent);
        }
    }
}
