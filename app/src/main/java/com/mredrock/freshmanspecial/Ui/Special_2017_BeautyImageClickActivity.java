package com.mredrock.freshmanspecial.Ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.BeautyImageClick;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.SchoolCanteen;
import com.mredrock.freshmanspecial.data.SchoolDormitory;
import com.mredrock.freshmanspecial.data.SchoolBuilding;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017BeautyImageClickBinding;

import java.util.ArrayList;

public class Special_2017_BeautyImageClickActivity extends AppCompatActivity {
    private ActivitySpecial2017BeautyImageClickBinding mBinding;
    private Special_2017_ViewPagerAdapter mAdapter;
    private ArrayList<SchoolCanteen> mCanteens = new ArrayList<>() ;
    private ArrayList<SchoolBuilding> mEnvironments =  new ArrayList<>();
    private ArrayList<SchoolDormitory> mDormitories = new ArrayList<>();
    private ArrayList<BeautyInCqupt> mBeautyInCqupts = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_special_2017__beauty_image_click);
        initView();

    }
    private void initView(){
        String type = getIntent().getStringExtra("type");
        int length = getIntent().getIntExtra("length",0);
        if (type.equals("canteen")){
            for (int i = 0; i < length ; i++) {
                mCanteens.add((SchoolCanteen) getIntent().getSerializableExtra("canteen"));
                mFragments.add(new BeautyImageClick());
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
            mBinding.special2017BeautyImageClickViewpager.setAdapter(mAdapter);

        } else if (type.equals("environment")){
            for (int i = 0; i < length ; i++) {
                mEnvironments.add((SchoolBuilding) getIntent().getSerializableExtra(type+i));
                mFragments.add(new BeautyImageClick());
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
            mBinding.special2017BeautyImageClickViewpager.setAdapter(mAdapter);

        } else if (type.equals("dormitory")){
            for (int i = 0; i < length ; i++) {
                mDormitories.add((SchoolDormitory) getIntent().getSerializableExtra(type+i));
                mFragments.add(new BeautyImageClick());
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
            mBinding.special2017BeautyImageClickViewpager.setAdapter(mAdapter);

        } else if (type.equals("beauty")){

            for (int i = 0; i < length ; i++) {
                mBeautyInCqupts.add((BeautyInCqupt) getIntent().getSerializableExtra(type+i));
                mFragments.add(new BeautyImageClick());
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mFragments);
            mBinding.special2017BeautyImageClickViewpager.setAdapter(mAdapter);

        }






    }
}
