package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.Organizations;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/8/14 0014.
 */

public class StudentOriganizationTitleAdapter extends RecyclerView.Adapter<StudentOriganizationTitleAdapter.StudentOriganizationTitleViewHolder>{
    private int location;
    private String[] titles;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ViewDataBinding mViewDataBinding;
    private StudentOrganizationAdapter mContentAdapter ;

    private StudentOriganizationTitleViewHolder mViewHolder  ;
    private ArrayList<StudentOriganizationTitleViewHolder> mViewHolders = new ArrayList<>();
    public StudentOriganizationTitleAdapter(Context context) {
        mContext = context;
        mLayoutInflater = new LayoutInflater(mContext) {
            @Override
            public LayoutInflater cloneInContext(Context context) {
                return null;
            }
        };
    }

    public StudentOrganizationAdapter getContentAdapter() {
        return mContentAdapter;
    }

    public void setContentAdapter(StudentOrganizationAdapter contentAdapter) {
        mContentAdapter = contentAdapter;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    @Override
    public StudentOriganizationTitleAdapter.StudentOriganizationTitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orgnazitions_title,parent,false);
        mViewHolder = new StudentOriganizationTitleViewHolder(view) ;
        mViewHolders.add(mViewHolder);
        return mViewHolder  ;
    }

    @Override
    public void onBindViewHolder(final StudentOriganizationTitleViewHolder holder, final int position) {
        holder.s = titles[position];
        if (position == 0){
            holder.mCardView.setBackgroundColor(Color.parseColor("#ECF6FF"));
        }
        holder.title.setText(holder.s);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearColor();
                holder.mCardView.setBackgroundColor(Color.parseColor("#ECF6FF"));
                mContentAdapter.setLocation(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return titles.length;
    }

    class StudentOriganizationTitleViewHolder extends RecyclerView.ViewHolder{
        CardView mCardView;
        TextView title;
        String s;
        public StudentOriganizationTitleViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView)itemView.findViewById(R.id.item_special_2017_organization_card);
            title = (TextView) itemView.findViewById(R.id.item_special_2017_organization_title);

        }
    }


    public void clearColor(){
        for (int j = 0; j < mViewHolders.size(); j++) {
            mViewHolders.get(j).mCardView.setBackgroundColor(Color.WHITE);
        }
    }
}
