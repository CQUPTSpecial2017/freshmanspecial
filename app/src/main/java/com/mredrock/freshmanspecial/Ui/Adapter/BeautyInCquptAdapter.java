package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Special_2017_BeautyImageClickActivity;
import com.mredrock.freshmanspecial.Ui.Special_2017_ImageClickActivity;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.SchoolCanteen;
import com.mredrock.freshmanspecial.data.SchoolDormitory;
import com.mredrock.freshmanspecial.data.SchoolEnvironment;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class BeautyInCquptAdapter extends RecyclerView.Adapter<BeautyInCquptAdapter.BeautyHolder> {

    private Context mContext;
    //type = 0 学校宿舍 , type = 1 学校食堂 , type = 2 美在重邮 , type = 3 学校环境
    private int type;
    private ArrayList<com.mredrock.freshmanspecial.data.SchoolDormitory> mDormitories = new ArrayList<>();
    private ArrayList<SchoolCanteen> mCanteens = new ArrayList<>();
    private ArrayList<com.mredrock.freshmanspecial.data.BeautyInCqupt> mBeautyInCqupts = new ArrayList<>();
    private ArrayList<SchoolEnvironment> mEnvironments = new ArrayList<>();

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

    public ArrayList<SchoolDormitory> getDormitories() {
        return mDormitories;
    }

    public void setDormitories(ArrayList<SchoolDormitory> dormitories) {
        mDormitories = dormitories;
        type = 0;
    }

    public ArrayList<SchoolCanteen> getCanteens() {
        return mCanteens;
    }

    public void setCanteens(ArrayList<SchoolCanteen> canteens) {
        mCanteens = canteens;
        type = 1;
    }

    public ArrayList<SchoolEnvironment> getEnvironments() {
        return mEnvironments;
    }

    public void setEnvironments(ArrayList<SchoolEnvironment> environments) {
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
                holder.title.setText(holder.mDormitory.getTitle());
                holder.information.setText(holder.mDormitory.getContent());

                holder.mCountLayout.setVisibility(View.VISIBLE);
                holder.mCount.setText(holder.mDormitory.getImageCount()+"张");
                holder.count = Integer.parseInt(holder.mDormitory.getImageCount());
                break;
            case 1:
                holder.mCanteen = mCanteens.get(position);
                holder.title.setText(holder.mCanteen.getTitle());
                holder.information.setText(holder.mCanteen.getContent());

                holder.mCountLayout.setVisibility(View.VISIBLE);
                holder.mCount.setText(holder.mCanteen.getImageCount()+"张");
                holder.count = Integer.parseInt(holder.mCanteen.getImageCount());
                break;
            case 2:
                holder.mBeautyInCqupt = mBeautyInCqupts.get(position);
                holder.title.setText(holder.mBeautyInCqupt.getTitle());
                holder.information.setText(holder.mBeautyInCqupt.getContent());

                holder.mCountLayout.setVisibility(View.GONE);
                break;
            case 4:
                holder.mEnvironment = mEnvironments.get(position);
                holder.title.setText(holder.mEnvironment.getTitle());
                holder.information.setText(holder.mEnvironment.getContent());

                holder.mCountLayout.setVisibility(View.GONE);
                break;

        }



    }


    @Override
    public int getItemCount() {

        if (type == 1)
            return mBeautyInCqupts.size();
        else return mDormitories.size();
    }




    class BeautyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView information;
        private ImageView image;
        private int count;
        private RelativeLayout mCountLayout;
        private TextView mCount;
        private BeautyInCqupt mBeautyInCqupt;
        private SchoolDormitory mDormitory;
        private SchoolCanteen mCanteen;
        private SchoolEnvironment mEnvironment;


        public BeautyHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_beauty_in_cqupt_title);
            information = (TextView) itemView.findViewById(R.id.item_beauty_in_cqupt_information);
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