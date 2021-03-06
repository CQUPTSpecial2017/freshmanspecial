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
import com.mredrock.freshmanspecial.Ui.Adapter.FoodAroundCquptAdapter;
import com.mredrock.freshmanspecial.data.*;
import com.mredrock.freshmanspecial.httptools.CquptMienData;
import com.mredrock.freshmanspecial.httptools.DataAboutFresh;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class DailyLife extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private Context mContext ;
    private FoodAroundCquptAdapter mAdapter;
    private ArrayList<LifeInNear> mDailyLifes = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_daily_life,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.daily_life_recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mContext = getContext();
        initView();

        super.onActivityCreated(savedInstanceState);
    }


    public void initView(){
        mAdapter = new FoodAroundCquptAdapter(mContext);

        mRecyclerView.setAdapter(mAdapter);

        DataAboutFresh.getInstance().getLifeInNear(new Subscriber<List<LifeInNear>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<LifeInNear> lifeInNears) {
                mDailyLifes.addAll(lifeInNears);
                mAdapter.setDailyLifes(mDailyLifes);
                mAdapter.notifyDataSetChanged();
            }
        },"LifeInNear");


    }
}
