package com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments;

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
import com.mredrock.freshmanspecial.Ui.Adapter.StudentOrganizationAdapter;
import com.mredrock.freshmanspecial.data.Organizations;
import com.mredrock.freshmanspecial.httptools.CquptMienData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class SchoolYouthAssociation  extends Fragment{
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private StudentOrganizationAdapter mAdapter ;
    private Context mContext ;
    private ArrayList<Organizations> mOrganizationses = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_school_youth_association,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.school_youth_association_recycle);

        mContext = getContext();
        mAdapter = new StudentOrganizationAdapter(mContext);

        if (mOrganizationses.size() == 0 ){
            CquptMienData.getInstance().getOrganizations(new Subscriber<List<Organizations>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<Organizations> organizationses) {
                    mOrganizationses.add(organizationses.get(5));
                    mAdapter.setDepartmentBeen(mOrganizationses.get(0).getDepartment());
                    mAdapter.notifyDataSetChanged();
                }
            },"Organizations");
        }



        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);

        super.onActivityCreated(savedInstanceState);
    }

}
