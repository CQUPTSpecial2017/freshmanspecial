package com.mredrock.freshmanspecial.Ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.BeautyInCqupt;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.CreateByCqupt;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.ExcellentStudent;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.ExcellentTeacher;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizations;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017CquptBeautyBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class Special_2017_BeautyActivity extends FragmentActivity {
    ActivitySpecial2017CquptBeautyBinding mBinding;
    private List<Fragment> mFragments;
    private Special_2017_ViewPagerAdapter mBeautyViewPagerAdapter;
    private String[] mTitles = {"学生组织","原创重邮","美在重邮","优秀教师","优秀学生"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017_cqupt_beauty);
        initView();
    }
    private void initView(){
        mFragments = new ArrayList<>();
        mFragments.add(new StudentOrganizations());
        mFragments.add(new CreateByCqupt());
        mFragments.add(new BeautyInCqupt());
        mFragments.add(new ExcellentTeacher());
        mFragments.add(new ExcellentStudent());

        mBeautyViewPagerAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mBeautyViewPagerAdapter.setTitles(mTitles);

        mBinding.cquptBeautyViewpager.setAdapter(mBeautyViewPagerAdapter);
        mBinding.cquptBeautyTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.cquptBeautyTabLayout.setupWithViewPager(mBinding.cquptBeautyViewpager);
    }
}
