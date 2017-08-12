package com.mredrock.freshmanspecial.Ui;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.BR;
import com.mredrock.freshmanspecial.Interface.Presenterable;
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
    private TextView inter;
    private ImageView back ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017_data);

        mFragments = new ArrayList<>();
        mFragments.add(new ManAndWoman());
        mFragments.add(new TheHardestObject());
        mFragments.add(new WorkPercent());
        inter = (TextView)binding.getRoot().findViewById(R.id.special_2017_data_inter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {

            inter.setVisibility(View.GONE);
        }
        mDataViewPagerAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mDataViewPagerAdapter.setTitles(mTitles);
        binding.dataViewpager.setAdapter(mDataViewPagerAdapter);
        binding.dataViewpager.setOffscreenPageLimit(2);


        binding.dataTabLayout.setTabMode(TabLayout.MODE_FIXED);
        binding.dataTabLayout.setupWithViewPager(binding.dataViewpager);
        binding.setVariable(BR.onClick,new Special_2017_DataActivity.Presenter());
    }
    public class Presenter implements Presenterable {
        public void onBack() {
            finish();
        }

    }
}
