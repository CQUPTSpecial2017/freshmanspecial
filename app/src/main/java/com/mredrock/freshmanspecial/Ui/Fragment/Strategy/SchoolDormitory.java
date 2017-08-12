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
import com.mredrock.freshmanspecial.data.*;
import com.mredrock.freshmanspecial.httptools.DataAboutFresh;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class SchoolDormitory extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private Context mContext ;
    private ArrayList<Dormitory> mDormitories = new ArrayList<>();
    private BeautyInCquptAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_school_dormitory,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        mContext = getContext();
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.school_dormitory_recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        if (mDormitories.size() == 0){
            DataAboutFresh.getInstance().getDormitory(new Subscriber<List<Dormitory>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<com.mredrock.freshmanspecial.data.Dormitory> dormitories) {
                    mDormitories.addAll(dormitories);
                    mAdapter.setDormitories(mDormitories);
                    mAdapter.notifyDataSetChanged();
                }
            },"Dormitory");
        }


        mAdapter = new BeautyInCquptAdapter(mContext);
        mAdapter.setDormitories(mDormitories);

        mRecyclerView.setAdapter(mAdapter);

        super.onActivityCreated(savedInstanceState);
    }
}
