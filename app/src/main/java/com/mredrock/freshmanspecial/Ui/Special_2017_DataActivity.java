package com.mredrock.freshmanspecial.Ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.ManAndWoman;
import com.mredrock.freshmanspecial.Ui.Fragment.TheHardestObject;
import com.mredrock.freshmanspecial.Ui.Fragment.WorkPercent;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017DataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class Special_2017_DataActivity extends FragmentActivity {
    private List<Fragment> mFragments;
    private  Special_2017_ViewPagerAdapter mDataViewPagerAdapter;
    private String[] mTitles = {"男女比例","最难科目","就业比例"};
    private ActivitySpecial2017DataBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017_data);
        mFragments = new ArrayList<>();
        mFragments.add(new ManAndWoman());
        mFragments.add(new TheHardestObject());
        mFragments.add(new WorkPercent());

        mDataViewPagerAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mDataViewPagerAdapter.setTitles(mTitles);
        binding.dataViewpager.setAdapter(mDataViewPagerAdapter);
        binding.dataViewpager.setOffscreenPageLimit(2);

        binding.dataTabLayout.setTabMode(TabLayout.MODE_FIXED);
        binding.dataTabLayout.setupWithViewPager(binding.dataViewpager);
    }
}
