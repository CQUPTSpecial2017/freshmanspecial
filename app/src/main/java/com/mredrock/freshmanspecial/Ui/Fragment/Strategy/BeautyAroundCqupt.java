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
import com.mredrock.freshmanspecial.Ui.Adapter.BeautyInCquptAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.FoodAroundCquptAdapter;
import com.mredrock.freshmanspecial.data.FoodAroundCqupt;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class BeautyAroundCqupt extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private Context mContext ;
    private FoodAroundCquptAdapter mAdapter;
    private ArrayList<com.mredrock.freshmanspecial.data.BeautyAroundCqupt> mAroundCqupts = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_beauty_aroud_cqupt,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.beauty_around_cqupt_recycle);
        mContext = getContext();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //请求数据


        mAdapter = new FoodAroundCquptAdapter(mContext);
        mAdapter.setBeautyAroundCqupts(mAroundCqupts);


        super.onActivityCreated(savedInstanceState);
    }
}
