package com.mredrock.freshmanspecial.Ui.Fragment.Strategy;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.RequirementsAdapter;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class Requirements extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private Context mContext ;
    private ArrayList<RequirementTitle> mDatas =new ArrayList<>();
    private RequirementsAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_requirements,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        mContext = getContext();



        mAdapter = new RequirementsAdapter(this.getContext(),mDatas);
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.item_requirement_recycle);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        super.onActivityCreated(savedInstanceState);
    }

}
