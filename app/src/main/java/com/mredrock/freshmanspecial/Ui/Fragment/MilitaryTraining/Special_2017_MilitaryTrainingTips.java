package com.mredrock.freshmanspecial.Ui.Fragment.MilitaryTraining;

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
 * Created by Administrator on 2017/8/13 0013.
 */

public class Special_2017_MilitaryTrainingTips extends Fragment{
    private ViewDataBinding mDataBinding;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_military_training_tips,container,false);
        return mDataBinding.getRoot();
    }
}
