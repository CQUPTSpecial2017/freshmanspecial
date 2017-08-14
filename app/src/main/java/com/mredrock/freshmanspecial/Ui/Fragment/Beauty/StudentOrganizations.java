package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.StudentOrganizationAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.StudentOriganizationTitleAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.ArtGroup;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.AssociationUnion;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.RedRock;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.SchoolStudentUnion;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.SchoolYouthAssociation;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.Techlink;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.YouthLeagueCommittee;
import com.mredrock.freshmanspecial.Ui.View.Special_2017_NoScrollViewPager;
import com.mredrock.freshmanspecial.data.Organizations;
import com.mredrock.freshmanspecial.httptools.CquptMienData;


import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class StudentOrganizations extends Fragment{
    private ViewDataBinding mDataBinding;
    private RecyclerView titleRecycler;
    private RecyclerView contentRecycler;
    private StudentOrganizationAdapter mContentAdapter ;
    private StudentOriganizationTitleAdapter mTitleAdapter;
    private Context mContext;
    private String[] mTitles  = {"团委部门","红岩","校学生会","科联","社联","校青协","大艺团"};
    private ArrayList<Organizations> mOrganizationses = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_student_organizations,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        titleRecycler = (RecyclerView)mDataBinding.getRoot().findViewById(R.id.item_special_2017_student_organizations_title_recycler);
        contentRecycler = (RecyclerView)mDataBinding.getRoot().findViewById(R.id.item_special_2017_student_organizations_content_recycler);
        mContentAdapter = new StudentOrganizationAdapter(mContext);
        mTitleAdapter = new StudentOriganizationTitleAdapter(mContext);
        mTitleAdapter.setTitles(mTitles);

        CquptMienData.getInstance().getOrganizations(new Subscriber<List<Organizations>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Organizations> organizationses) {

                mOrganizationses.addAll(organizationses);
                mContentAdapter.setDepartmentBeen(mOrganizationses);
                mContentAdapter.notifyDataSetChanged();
            }
        },"organizations");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        contentRecycler.setAdapter(mContentAdapter);
        contentRecycler.setLayoutManager(linearLayoutManager);

        titleRecycler.setAdapter(mTitleAdapter);
        mTitleAdapter.setContentAdapter(mContentAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mContext);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        titleRecycler.setLayoutManager(linearLayoutManager1);

        initView();

    }


    private void initView(){







    }
}
