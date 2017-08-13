package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.BeautyInCquptAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.CreateByCquptAdapter;
import com.mredrock.freshmanspecial.data.*;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.httptools.CquptMienData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class CreateByCqupt extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private CreateByCquptAdapter mAdapter;
    private ArrayList<NatureCQUPT> mCQUPTs = new ArrayList<>();
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_create_by_cqupt,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.create_by_cqupt_recycle);

        mContext = getContext();
        mAdapter = new CreateByCquptAdapter(mContext);

        if (mCQUPTs.size() == 0){
            CquptMienData.getInstance().getNatureCQUPT(new Subscriber<List<NatureCQUPT>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<NatureCQUPT> natureCQUPTs) {
                    mCQUPTs.clear();
                    mCQUPTs.addAll(natureCQUPTs);
                    mAdapter.setCreates(mCQUPTs);
                    mAdapter.notifyDataSetChanged();
                }
            },"natureCQUPT");
        }



        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        mRecyclerView.setAdapter(mAdapter);
    }
}
