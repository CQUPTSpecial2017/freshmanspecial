package com.mredrock.freshmanspecial.Ui.Fragment.Beauty;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class BeautyInCqupt extends Fragment {
    ViewDataBinding mDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_beauty_in_cqupt,container,false);
        return mDataBinding.getRoot();
    }
}
