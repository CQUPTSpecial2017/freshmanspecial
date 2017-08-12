package com.mredrock.freshmanspecial.Ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.ExcellentStudent;
import com.mredrock.freshmanspecial.data.ExcellentTeacher;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017ImageClickBinding;


public class Special_2017_ImageClickActivity extends Activity {
    private ActivitySpecial2017ImageClickBinding mBinding;

    private ExcellentTeacher mTeacher ;
    private ExcellentStudent mStudent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_special_2017_image_click);
        initView();

    }
    private void initView(){
        String type = getIntent().getStringExtra("type");
        if (type.equals("teacher")){
            mTeacher = (ExcellentTeacher) getIntent().getSerializableExtra(type);
            //mBinding.special2017ImageClickInformation.setText(mTeacher.getName());
            mBinding.special2017ImageClickName.setText(mTeacher.getName());

        }
        else {
            mStudent = (ExcellentStudent) getIntent().getSerializableExtra(type);
            //mBinding.special2017ImageClickInformation.setText(mStudent);
            mBinding.special2017ImageClickName.setText(mStudent.getName());
        }
        mBinding.special2017ImageClickCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





    }

}
