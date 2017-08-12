package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

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
import com.mredrock.freshmanspecial.httptools.CquptMienData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;


/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class BeautyInCqupt extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private BeautyInCquptAdapter mAdapter;
    private Context mContext ;
    private ArrayList<com.mredrock.freshmanspecial.data.BeautyInCqupt> mBeautyInCqupts = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_beauty_in_cqupt,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.beauty_in_cqupt_recycle);
        if (mBeautyInCqupts.size() == 0){
            CquptMienData.getInstance().getBeautyInCqupt(new Subscriber<List<com.mredrock.freshmanspecial.data.BeautyInCqupt>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<com.mredrock.freshmanspecial.data.BeautyInCqupt> beautyInCqupts) {
                    mBeautyInCqupts.addAll(beautyInCqupts);
                    mAdapter.setBeautyInCqupts(mBeautyInCqupts);
                    mAdapter.notifyDataSetChanged();
                }
            },"beautyInCQUPT");
        }


        mContext = getContext();
        mAdapter = new BeautyInCquptAdapter(mContext);
        mAdapter.setBeautyInCqupts(mBeautyInCqupts);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        super.onActivityCreated(savedInstanceState);
    }
}
