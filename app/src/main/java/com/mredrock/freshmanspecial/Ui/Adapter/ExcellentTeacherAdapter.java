package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class ExcellentTeacherAdapter extends RecyclerView.Adapter<ExcellentTeacherAdapter.TeacherViewHolder> {
    private LayoutInflater mLayoutInflater ;
    private List mData;

    public ExcellentTeacherAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public ExcellentTeacherAdapter() {
    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class TeacherViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
        private ViewDataBinding mBinding ;
        public TeacherViewHolder(T binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }
    }
}
