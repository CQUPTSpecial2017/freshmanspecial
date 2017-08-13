package com.mredrock.freshmanspecial.Ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.mredrock.freshmanspecial.BR;
import com.mredrock.freshmanspecial.Interface.Presenterable;
import com.mredrock.freshmanspecial.R;

import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.BeautyImageClick;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.Canteen;



import com.mredrock.freshmanspecial.data.Dormitory;


import com.mredrock.freshmanspecial.data.SchoolBuilding;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017BeautyImageClickBinding;

import java.util.ArrayList;
import java.util.List;

public class Special_2017_BeautyImageClickActivity extends AppCompatActivity {
    private ActivitySpecial2017BeautyImageClickBinding mBinding;

    private Special_2017_ViewPagerAdapter mAdapter;
    private Canteen mCanteen = new Canteen ();
    private Context mContext =this;
    private Dormitory mDormitorie = new Dormitory();
    private List<Fragment> mImageClicks = new ArrayList<>();


    private ArrayList<String> mStrings = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_special_2017__beauty_image_click);
        initView();

    }
    private void initView(){



        String type = getIntent().getStringExtra("type");
        final int length = getIntent().getIntExtra("length",0);
        mBinding.activityImageClickCount.setText("1/"+length);
        if (type.equals("canteen")){
            mCanteen = (Canteen) getIntent().getSerializableExtra("canteen");
            mStrings.clear();
            for (int i = 0; i < length ; i++) {
                mStrings.add(mCanteen.getUrl().get(i));
                BeautyImageClick beautyImageClick = new BeautyImageClick();
                beautyImageClick.setUrl(mStrings.get(i));
                beautyImageClick.setContent(mCanteen.getName());
                mImageClicks.add(beautyImageClick);
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mImageClicks);
            mBinding.activityImageClickViewpager.setAdapter(mAdapter);
            mBinding.activityImageClickViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mBinding.activityImageClickCount.setText(position+1+"/"+length);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        else if (type.equals("dormitory")){
            mDormitorie = (Dormitory) getIntent().getSerializableExtra("dormitory");
            mStrings.clear();
            for (int i = 0; i < length ; i++) {
                mStrings.add(mDormitorie.getUrl().get(i));
                BeautyImageClick beautyImageClick = new BeautyImageClick();
                beautyImageClick.setUrl(mStrings.get(i));
                beautyImageClick.setContent(mCanteen.getName());
                mImageClicks.add(beautyImageClick);
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(),mImageClicks);
            mBinding.activityImageClickViewpager.setAdapter(mAdapter);
            mBinding.activityImageClickViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mBinding.activityImageClickCount.setText(position+1+"/"+length);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        else if (type.equals("training")) {
            mStrings.clear();
            for (int i = 0; i < length; i++) {
                mStrings.add(getIntent().getStringExtra(i + "url"));
                BeautyImageClick beautyImageClick = new BeautyImageClick();
                beautyImageClick.setUrl(mStrings.get(i));
                beautyImageClick.setContent(getIntent().getStringExtra(i + "name"));
                mImageClicks.add(beautyImageClick);
            }
            mAdapter = new Special_2017_ViewPagerAdapter(getSupportFragmentManager(), mImageClicks);
            mBinding.activityImageClickViewpager.setAdapter(mAdapter);
            mBinding.activityImageClickViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mBinding.activityImageClickCount.setText(position + 1 + "/" +length);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        mBinding.setVariable(BR.onClick,new Presenter());

    }
    public class Presenter implements Presenterable {
        public void onBack() {
            finish();
        }

    }
}
