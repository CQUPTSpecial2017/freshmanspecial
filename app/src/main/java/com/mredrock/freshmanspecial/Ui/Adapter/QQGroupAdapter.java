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
import java.util.List;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class QQGroupAdapter extends RecyclerView.Adapter<QQGroupAdapter.QQGroupViewHolder>{
    private ArrayList<QQGroupNumber.CollegeBean> mCollegeBeen = new ArrayList<>();
    private ArrayList<QQGroupNumber.HomelandBean> mHomelandBeen = new ArrayList<>();
    private ArrayList<String> mSearchResults = new ArrayList<>();
    private int type ;

    private Context mContext;
    private QQGroupAdapter.QQGroupViewHolder mViewHolder ;

    public ArrayList<String> getSearchResults() {
        return mSearchResults;
    }

    public void setSearchResults(ArrayList<String> searchResults) {
        mSearchResults = searchResults;
        type = 2;
    }

    public QQGroupAdapter(Context context) {
        mContext = context;

    }

    public QQGroupAdapter() {

    }

    public void setHomelandBeen(List<QQGroupNumber.HomelandBean> homelandBeen) {
        mHomelandBeen .addAll(homelandBeen) ;
        type = 0 ;
    }

    public void setCollegeBeen(List<QQGroupNumber.CollegeBean> collegeBeen) {
        mCollegeBeen .addAll(collegeBeen);
        type = 1 ;
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public QQGroupAdapter.QQGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_qq_group_content,parent,false);
        mViewHolder = new QQGroupAdapter.QQGroupViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(QQGroupAdapter.QQGroupViewHolder holder, int position) {
        if (type == 1 )
        holder.content.setText(mCollegeBeen.get(position).getGroupName()+" : "+mCollegeBeen.get(position).getNumber());
        else if (type == 0)
            holder.content.setText(mHomelandBeen.get(position).getGroupName()+" : "+mHomelandBeen.get(position).getNumber());
        else
            holder.content.setText(mSearchResults.get(position));

    }



    @Override
    public int getItemCount() {
        if (type == 1)
        return mCollegeBeen.size();
        else if (type == 0)
            return mHomelandBeen.size();
        else
            return mSearchResults.size();
    }

    class QQGroupViewHolder  extends RecyclerView.ViewHolder{
        private TextView content ;

        public QQGroupViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.special_2017_qq_group_content);
        }
    }
}
