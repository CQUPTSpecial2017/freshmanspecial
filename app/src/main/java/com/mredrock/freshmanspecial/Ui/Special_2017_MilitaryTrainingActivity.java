package com.mredrock.freshmanspecial.Ui;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.BR;
import com.mredrock.freshmanspecial.Interface.Presenterable;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.MenAndWomen;
import com.mredrock.freshmanspecial.Ui.Fragment.MilitaryTraining.Specail_2017_MartialArtOfMilitaryTraining;
import com.mredrock.freshmanspecial.Ui.Fragment.MilitaryTraining.Special_2017_MilitaryTrainingTips;
import com.mredrock.freshmanspecial.Ui.Fragment.TheHardestObject;
import com.mredrock.freshmanspecial.Ui.Fragment.WorkPercent;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017DataBinding;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017MilitaryTrainingBinding;

import java.util.ArrayList;
import java.util.List;

public class Special_2017_MilitaryTrainingActivity extends AppCompatActivity {
    private List<Fragment> mFragments;
    private Special_2017_ViewPagerAdapter mDataViewPagerAdapter;
    private String[] mTitles = {"军训贴士","军训特辑"};
    private ActivitySpecial2017MilitaryTrainingBinding binding;
    private TextView inter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017_military_training);
        initView();

    }


    private void initView(){
        mFragments = new ArrayList<>();

        mFragments.add(new Special_2017_MilitaryTrainingTips());
        mFragments.add(new Specail_2017_MartialArtOfMilitaryTraining());

        inter = (TextView)binding.getRoot().findViewById(R.id.special_2017_military_inter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {

            inter.setVisibility(View.GONE);
        }
        mDataViewPagerAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mDataViewPagerAdapter.setTitles(mTitles);
        binding.militaryViewpager.setAdapter(mDataViewPagerAdapter);
        binding.militaryViewpager.setOffscreenPageLimit(2);


        binding.militaryTabLayout.setTabMode(TabLayout.MODE_FIXED);
        binding.militaryTabLayout.setupWithViewPager(binding.militaryViewpager);
        binding.setVariable(BR.onClick,new Special_2017_MilitaryTrainingActivity.Presenter());
    }



    public class Presenter implements Presenterable {
        public void onBack() {
            finish();
        }

    }
}
