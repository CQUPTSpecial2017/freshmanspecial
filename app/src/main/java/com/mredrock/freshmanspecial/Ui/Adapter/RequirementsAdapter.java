package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class RequirementsAdapter extends RecyclerView.Adapter<RequirementsAdapter.RequirementsViewHolder> {
    private ArrayList<RequirementTitle> mDatas = new ArrayList<>();
    private Context mContext;
    private RequirementsViewHolder mViewHolder ;
    private int type;
    public RequirementsAdapter(Context context) {
        mContext = context;

    }

    public RequirementsAdapter() {

    }

    public void setDatas(ArrayList<RequirementTitle> datas) {
        mDatas = datas;
        type = 0;
    }

    @Override
    public RequirementsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_requirement,parent,false);
        mViewHolder = new RequirementsAdapter.RequirementsViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RequirementsViewHolder holder, int position) {
        holder.title.setText(mDatas.get(position).getTitle());
        holder.mRecyclerView.setAdapter(new RequirementsContentAdapter(mDatas.get(position).getContent()));
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }



    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class RequirementsViewHolder  extends RecyclerView.ViewHolder{
        private TextView title ;
        private RecyclerView mRecyclerView;

           public RequirementsViewHolder(View itemView) {
               super(itemView);
               title = (TextView)itemView.findViewById(R.id.item_requirement_title);
               mRecyclerView = (RecyclerView)itemView.findViewById(R.id.item_requirement_recycle);
           }
       }
}
