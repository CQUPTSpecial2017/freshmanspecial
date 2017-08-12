package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

import android.content.Context;
import android.database.DatabaseUtils;
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
import com.mredrock.freshmanspecial.Ui.Adapter.ExcellentTeacherAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class ExcellentTeacher extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private ExcellentTeacherAdapter mAdapter;
    private Context mContext ;
    private ArrayList<com.mredrock.freshmanspecial.data.ExcellentTeacher> mTeachers = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_excellent_teacher,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.excellent_teachers_recycle);
        if (mTeachers.size() == 0)
        mTeachers.add(new com.mredrock.freshmanspecial.data.ExcellentTeacher("陈琪琪","传媒艺术学院","sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",""));
        mContext = getContext();
        mAdapter = new ExcellentTeacherAdapter(mContext);
        mAdapter.setTeachers(mTeachers);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        super.onActivityCreated(savedInstanceState);
    }
}
