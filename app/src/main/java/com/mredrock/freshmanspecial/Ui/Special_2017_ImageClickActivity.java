package com.mredrock.freshmanspecial.Ui;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.ExcellentStu;
import com.mredrock.freshmanspecial.data.ExcellentTech;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017ImageClickBinding;


public class Special_2017_ImageClickActivity extends Activity {
    private ActivitySpecial2017ImageClickBinding mBinding;

    private ExcellentTech mTeacher ;
    private ExcellentStu mStudent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_special_2017_image_click);

        initView();

    }
    private void initView(){



        mStudent = (ExcellentStu) getIntent().getSerializableExtra("student");
        mBinding.special2017ImageClickInformation.setText(mStudent.getResume());
        mBinding.special2017ImageClickName.setText(mStudent.getName());

        Glide.with(mBinding.special2017ImageClickAvatar.getContext())
                .load(mStudent.getUrl())
                .crossFade()
                .into(mBinding.special2017ImageClickAvatar);

        mBinding.special2017ImageClickCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





    }

}
