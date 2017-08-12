package com.mredrock.freshmanspecial.Ui;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.BeautyInCqupt;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.CreateByCqupt;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.ExcellentStudent;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.ExcellentTeacher;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizations;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.BeautyAroundCqupt;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.DailyLife;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.FoodAroundSchool;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.QQTeam;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.Requirements;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.SchoolCanteen;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.SchoolDormitory;
import com.mredrock.freshmanspecial.Ui.Fragment.Strategy.SchoolEnvironment;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017StrategyBinding;
;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class Special_2017_StrategyActivity extends AppCompatActivity {
    private ActivitySpecial2017StrategyBinding mBinding;
    private List<Fragment> mFragments;
    private Special_2017_ViewPagerAdapter mBeautyViewPagerAdapter;
    private TextView inter;
    private String[] mTitles = {"校园环境","学生寝室","学校食堂","QQ群","日常生活","周边美食","周边美景"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017_strategy);
        initView();
    }
    private void initView(){
        mFragments = new ArrayList<>();
        mFragments.add(new SchoolEnvironment());
        mFragments.add(new SchoolDormitory());
        mFragments.add(new SchoolCanteen());
        //mFragments.add(new Requirements());
        mFragments.add(new QQTeam());
        mFragments.add(new DailyLife());
        mFragments.add(new FoodAroundSchool());
        mFragments.add(new BeautyAroundCqupt());

        inter = (TextView)mBinding.getRoot().findViewById(R.id.special_2017_beauty_inter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {

            inter.setVisibility(View.GONE);
        }
        mBeautyViewPagerAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mBeautyViewPagerAdapter.setTitles(mTitles);

        mBinding.cquptStrategyViewpager.setAdapter(mBeautyViewPagerAdapter);
        mBinding.cquptStrategyTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.cquptStrategyTabLayout.setupWithViewPager(mBinding.cquptStrategyViewpager);
    }
}
