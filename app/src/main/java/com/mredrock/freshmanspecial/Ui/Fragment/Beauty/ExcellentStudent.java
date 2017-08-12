package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.ExcellentTeacherAdapter;
import com.mredrock.freshmanspecial.data.*;
import com.mredrock.freshmanspecial.httptools.CquptMienData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class ExcellentStudent  extends Fragment{
    private ArrayList<ExcellentStu> mStudents = new ArrayList<>();
    private ExcellentTeacherAdapter mAdapter;
    private Context mContext ;

    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_excellent_student,container,false);
        return mDataBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.excellent_students_recycle);


        mContext = getContext();
        mAdapter = new ExcellentTeacherAdapter(mContext);
        CquptMienData.getInstance().getExcellentStu(new Subscriber<List<ExcellentStu>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("ExcellentStudent",e.toString());
            }

            @Override
            public void onNext(List<ExcellentStu> excellentStus) {
                mStudents.addAll(excellentStus);
                mAdapter.setStudents(mStudents);
                mAdapter.notifyDataSetChanged();
            }
        },"ExcellentStu");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        super.onActivityCreated(savedInstanceState);
    }
}
