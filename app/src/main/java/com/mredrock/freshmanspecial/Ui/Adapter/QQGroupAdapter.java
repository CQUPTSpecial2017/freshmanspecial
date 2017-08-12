package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class QQGroupAdapter extends RecyclerView.Adapter<QQGroupAdapter.QQGroupViewHolder>{
    private ArrayList<RequirementTitle> mDatas = new ArrayList<>();
    private Context mContext;
    private QQGroupAdapter.QQGroupViewHolder mViewHolder ;
    private ArrayList<QQGroupNumber> mNumber = new ArrayList<>();
    public QQGroupAdapter(Context context, ArrayList<RequirementTitle> content) {
        mContext = context;
        mDatas = content;
    }

    public QQGroupAdapter() {

    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public QQGroupAdapter.QQGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_qq_group_title,parent,false);
        mViewHolder = new QQGroupAdapter.QQGroupViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(QQGroupAdapter.QQGroupViewHolder holder, int position) {
        holder.title.setText(mDatas.get(position).getTitle());
        holder.mRecyclerView.setAdapter(new RequirementsContentAdapter(mDatas.get(position).getContent()));
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }



    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class QQGroupViewHolder  extends RecyclerView.ViewHolder{
        private TextView title ;
        private RecyclerView mRecyclerView;

        public QQGroupViewHolder(View itemView) {
            super(itemView);
        }
    }
}
