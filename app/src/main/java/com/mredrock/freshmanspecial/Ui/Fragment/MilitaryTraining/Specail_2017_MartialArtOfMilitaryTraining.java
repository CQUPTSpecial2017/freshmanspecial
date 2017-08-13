package com.mredrock.freshmanspecial.Ui.Fragment.MilitaryTraining;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.StudentOrganizationAdapter;
import com.mredrock.freshmanspecial.data.Organizations;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/13 0013.
 */

public class Specail_2017_MartialArtOfMilitaryTraining extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;

    private Context mContext ;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_military_training_martial_art,container,false);
        return mDataBinding.getRoot();
    }
}
