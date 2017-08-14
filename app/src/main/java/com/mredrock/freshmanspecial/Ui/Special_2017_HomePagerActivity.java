package com.mredrock.freshmanspecial.Ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Interface.Presenterable;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.databinding.ActivitySpecial2017HomePagerBinding;
import com.mredrock.freshmanspecial.httptools.CquptMienData;
import com.mredrock.freshmanspecial.httptools.NetWorkUtil;

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
        CquptMienData.getInstance().getBeautyInCqupt(new Subscriber<List<BeautyInCqupt>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<BeautyInCqupt> beautyInCqupts) {
                Log.d("s",beautyInCqupts.size()+"");
            }
        },"BeautyInCqupt");


    }

    public class Presenter implements Presenterable {
        @Override
        public void onBack() {
            finish();
        }
        public void onStrategyClick(){
            if (NetWorkUtil.isNetworkAvailable(Special_2017_HomePagerActivity.this))
            {      startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_StrategyActivity.class));

            }
            else
                Toast.makeText(Special_2017_HomePagerActivity.this,"网络不可用",Toast.LENGTH_SHORT).show();

        }
        public void onDataClick(){
            if (NetWorkUtil.isNetworkAvailable(Special_2017_HomePagerActivity.this))
            {        startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_DataActivity.class));

            }
            else
                Toast.makeText(Special_2017_HomePagerActivity.this,"网络不可用",Toast.LENGTH_SHORT).show();

        }
        public void onBeautyClick(){
            if (NetWorkUtil.isNetworkAvailable(Special_2017_HomePagerActivity.this))
            {    startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_BeautyActivity.class));

            }
            else
                Toast.makeText(Special_2017_HomePagerActivity.this,"网络不可用",Toast.LENGTH_SHORT).show();

        }
        public void onTrainingClick(){
            if (NetWorkUtil.isNetworkAvailable(Special_2017_HomePagerActivity.this))
            
            {        startActivity(new Intent(Special_2017_HomePagerActivity.this,Special_2017_MilitaryTrainingActivity.class));

            }
            else
                Toast.makeText(Special_2017_HomePagerActivity.this,"网络不可用",Toast.LENGTH_SHORT).show();


        }
    }
}
