package com.mredrock.freshmanspecial.Ui.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Ui.View.Special_2017_Lazy.LazyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class Special_2017_ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments ;
    private String[] mTitles;

    public void setTitles(String[] titles) {
        mTitles = titles;
    }

    public Special_2017_ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments.addAll(fragments);

    }



    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }



}
