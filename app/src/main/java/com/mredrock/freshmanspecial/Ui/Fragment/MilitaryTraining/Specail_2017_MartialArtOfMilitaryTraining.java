package com.mredrock.freshmanspecial.Ui.Fragment.MilitaryTraining;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.StudentOrganizationAdapter;
import com.mredrock.freshmanspecial.Ui.Adapter.TrainingImageAdapter;
import com.mredrock.freshmanspecial.data.MilitaryTrainingPhoto;
import com.mredrock.freshmanspecial.data.MilitaryTrainingVideo;
import com.mredrock.freshmanspecial.data.Organizations;
import com.mredrock.freshmanspecial.httptools.CquptMienData;
import com.mredrock.freshmanspecial.httptools.DataAboutFresh;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/13 0013.
 */

public class Specail_2017_MartialArtOfMilitaryTraining extends Fragment  implements View.OnClickListener{
    private ViewDataBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private TrainingImageAdapter mAdapter ;
    private Context mContext ;
    private ImageView image1;
    private ImageView image2;
    private TextView text1;
    private TextView text2;
    private ArrayList<String> url = new ArrayList<>();

    private MilitaryTrainingPhoto mMilitaryTrainingPhoto;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_military_training_martial_art,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image1 = (ImageView) mDataBinding.getRoot().findViewById(R.id.special_2017_military_martial_video_image_1) ;
        image2 = (ImageView) mDataBinding.getRoot().findViewById(R.id.special_2017_military_martial_video_image_2) ;
        text1 = (TextView) mDataBinding.getRoot().findViewById(R.id.special_2017_military_martial_video_image_1_name) ;
        text2 = (TextView) mDataBinding.getRoot().findViewById(R.id.special_2017_military_martial_video_image_2_name) ;

        mRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.special_2017_military_martial_picture_recycler);
        mContext = getContext();
        mAdapter = new TrainingImageAdapter(mContext);

        DataAboutFresh.getInstance().getMilitaryTrainingPhoto(new Subscriber<MilitaryTrainingPhoto>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                   e.printStackTrace();
                }

            @Override
            public void onNext(MilitaryTrainingPhoto militaryTrainingPhoto) {
                mMilitaryTrainingPhoto = militaryTrainingPhoto;
                mAdapter.setUrls(mMilitaryTrainingPhoto.getUrl());
                mAdapter.setNames(mMilitaryTrainingPhoto.getTitle());
                mAdapter.notifyDataSetChanged();
            }


            },"MilitaryTrainingPhoto");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        DataAboutFresh.getInstance().getMilitaryTrainingVideo(new Subscriber<List<MilitaryTrainingVideo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MilitaryTrainingVideo> militaryTrainingVideos) {

                Glide.with(mContext)
                        .load(militaryTrainingVideos.get(0).getCover())
                        .crossFade()
                        .into(image1);
                url.add(militaryTrainingVideos.get(0).getUrl());
                text1.setText(militaryTrainingVideos.get(0).getTitle());
                Glide.with(mContext)
                        .load(militaryTrainingVideos.get(1).getCover())
                        .crossFade()
                        .into(image2);
                url.add(militaryTrainingVideos.get(1).getUrl());
                text2.setText(militaryTrainingVideos.get(1).getTitle());
            }
        },"MilitaryTrainingVideo");
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.special_2017_military_martial_video_image_1:
                Intent intent= new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(url.get(0));
                intent.setData(content_url);
                intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                mContext.startActivity(intent);
                break;
            case R.id.special_2017_military_martial_video_image_2:
                Intent intent1= new Intent();
                intent1.setAction("android.intent.action.VIEW");
                Uri content_url1 = Uri.parse(url.get(1));
                intent1.setData(content_url1);
                intent1.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                mContext.startActivity(intent1);
                break;
        }
    }
}
