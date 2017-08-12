package com.mredrock.freshmanspecial.Ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Interface.Presenterable;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017HomePagerBinding;
import com.mredrock.freshmanspecial.httptools.GetDataFromServe;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class Special_2017_HomePagerActivity extends AppCompatActivity {
    private TextView inter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySpecial2017HomePagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_special_2017__home_pager);
        binding.setOnClick(new Presenter());
        inter = (TextView) binding.getRoot().findViewById(R.id.special_2017_home_pager_inter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {

            inter.setVisibility(View.GONE);
        }


    }

    public class Presenter implements Presenterable {
        @Override
        public void onBack() {
            finish();
        }
        public void onStrategyClick(){
            startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_StrategyActivity.class));
        }
        public void onDataClick(){
            startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_DataActivity.class));
        }
        public void onBeautyClick(){
            startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_BeautyActivity.class));

        }
    }
}
