package com.mredrock.freshmanspecial.Ui.Fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;


/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class BeautyImageClick extends Fragment {
    private ViewDataBinding mDataBinding;
    private Context mContext ;
    private ImageView mImageView ;
    private TextView content;
    private String mContent;
    private String mUrl;

    public BeautyImageClick() {
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_beauty_image_click,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mImageView = (ImageView)mDataBinding.getRoot().findViewById(R.id.item_image_click_image);
        content = (TextView) mDataBinding.getRoot().findViewById(R.id.item_image_click_content);
        Glide.with(mContext)
                .load(mUrl)
                .crossFade()
                .into(mImageView);
        content.setText(mContent);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}
