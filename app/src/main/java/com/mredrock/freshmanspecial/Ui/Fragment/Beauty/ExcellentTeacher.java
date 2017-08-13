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
import com.mredrock.freshmanspecial.Ui.Adapter.CreateByCquptAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.ExcellentTeacherAdapter;
import com.mredrock.freshmanspecial.data.ExcellentTech;
import com.mredrock.freshmanspecial.data.NatureCQUPT;
import com.mredrock.freshmanspecial.httptools.CquptMienData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class ExcellentTeacher extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private CreateByCquptAdapter mAdapter;
    private Context mContext ;
    private ArrayList<ExcellentTech> mTeachers = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_excellent_teacher,container,false);
        return mDataBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.excellent_teachers_recycle);

        mContext = getContext();
        mAdapter = new CreateByCquptAdapter(mContext);


            CquptMienData.getInstance().getexcellentTech(new Subscriber<List<ExcellentTech>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<ExcellentTech> excellentTeches) {
                    mTeachers.clear();
                    mTeachers.addAll(excellentTeches);
                    mAdapter.setTeches(mTeachers);
                    mAdapter.notifyDataSetChanged();
                }
            },"excellentTech");

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        mRecyclerView.setAdapter(mAdapter);
        super.onActivityCreated(savedInstanceState);
    }
}
