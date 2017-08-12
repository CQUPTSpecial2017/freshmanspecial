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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.Special_2017_ViewPagerAdapter;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.ArtGroup;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.AssociationUnion;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.RedRock;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.SchoolStudentUnion;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.SchoolYouthAssociation;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.Techlink;
import com.mredrock.freshmanspecial.Ui.Fragment.Beauty.StudentOrganizationsFragments.YouthLeagueCommittee;


import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class StudentOrganizations extends Fragment{
    private ViewDataBinding mDataBinding;
    private Special_2017_ViewPagerAdapter mViewPagerAdapter;
    private ViewPager mViewPager;
    private MagicIndicator mMagicIndicator;
    private String[] mTitles  = {"团委部门","红岩","校学生会","科联","社联","校青协","大艺团"};
    private ArrayList<Fragment> mFragments  =new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_student_organizations,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMagicIndicator = (MagicIndicator) mDataBinding.getRoot().findViewById(R.id.item_special_2017_student_organizations_magic_indicator);
        mViewPager = (ViewPager) mDataBinding.getRoot().findViewById(R.id.item_special_2017_student_organizations_viewpager);

        initView();

    }


    private void initView(){
        mFragments.add(new YouthLeagueCommittee());
        mFragments.add(new RedRock());
        mFragments.add(new SchoolStudentUnion());
        mFragments.add(new Techlink());
        mFragments.add(new AssociationUnion());
        mFragments.add(new SchoolYouthAssociation());
        mFragments.add(new ArtGroup());


        mViewPagerAdapter = new Special_2017_ViewPagerAdapter(getFragmentManager(),mFragments);
        mViewPagerAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mViewPagerAdapter);

        CommonNavigator commonNavigator = new CommonNavigator(this.getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 7;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setSelectedColor(Color.GRAY);
                colorTransitionPagerTitleView.setTextSize(13);
                colorTransitionPagerTitleView.setText(mTitles[index]);

                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                WrapPagerIndicator indicator = new WrapPagerIndicator(context);
                indicator.setFillColor(Color.parseColor("#ECF6FF"));
                indicator.setRoundRadius(10);
                return indicator;
            }
        });
        mMagicIndicator.setNavigator(commonNavigator);

        ViewPagerHelper.bind(mMagicIndicator, mViewPager);

    }
}
