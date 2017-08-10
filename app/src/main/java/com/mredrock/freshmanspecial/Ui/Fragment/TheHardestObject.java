package com.mredrock.freshmanspecial.Ui.Fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bigkoo.pickerview.listener.OnDismissListener;
import com.mredrock.freshmanspecial.BR;
import com.mredrock.freshmanspecial.Model.Special_2017_Circle;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Fragment.Presenterable.Presenterable;
import com.mredrock.freshmanspecial.Ui.View.MyPickerView.OptionsPickerView;
import com.mredrock.freshmanspecial.Ui.View.MyPickerView.lib.WheelView;
import com.mredrock.freshmanspecial.Ui.View.MyPickerView.listener.CustomListener;
import com.mredrock.freshmanspecial.Ui.View.Special_2017_MyCircleView;
import com.mredrock.freshmanspecial.data.FailPlus;
import com.mredrock.freshmanspecial.data.SexRatio;
import com.mredrock.freshmanspecial.httptools.GetDataFromServer;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class TheHardestObject extends Fragment {
    private ViewDataBinding binding;
    private Special_2017_MyCircleView yellowCircleView;
    private Special_2017_MyCircleView greenCircleView;
    private Special_2017_MyCircleView blueCircleView;
    private OptionsPickerView mPickerView;
    private ArrayList<String> collegeItems  = new ArrayList<>();
    private ArrayList<ArrayList<String>> departmentItems =new ArrayList<ArrayList<String>>();
    private ArrayList<FailPlus> mData  = new ArrayList<>();
    private Subscriber<ArrayList<FailPlus>> mSubscriber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_the_hardest_object,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setVariable(BR.special_2017_the_hardest_object_presenter,new Presenter());
        mSubscriber = new Subscriber<ArrayList<FailPlus>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ArrayList<FailPlus> failPluses) {
                mData.addAll(failPluses);
                for (int i = 0; i < failPluses.size(); i++) {
                    collegeItems.add(failPluses.get(i).getCollege());
                    for (int j = 0; j < failPluses.get(i).getMajor().size(); j++) {
                        Log.d("size",failPluses.size()+"");
                        departmentItems.get(i).add( failPluses.get(i).getMajor().get(j).getMajor());
                    }

                }
            }
        };

        GetDataFromServer.getInstance().getFailRatio(mSubscriber,"FailPlus");
        initOptionPicker();
        yellowCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_yellow);
        yellowCircleView.setCircle(new Special_2017_Circle(100,0,"#FBFEB9","#f1e28c","#fffffb","#fcfae6","#fef9a2","#fbffc7"));
        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#B9E5FE","#7ac9eb","#f8fdfe","#ccf5ff","#a5e1fe","#c2eafe"));
        greenCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_green);
        greenCircleView.setCircle(new Special_2017_Circle(80,0,"#9dfced","#6de9d7","#f8fffe","#d7fff7","#81f9e8","#a8fef0"));
    }


    public void initOptionPicker(){
        mPickerView = new OptionsPickerView.Builder(this.getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {


            }
        })      .setLayoutRes(R.layout.pickerview_academy, new CustomListener() {
            @Override
            public void customLayout(View v) {

            }
        })
                .setTitleBgColor(Color.parseColor("#f2fafa"))
                .setContentTextSize(16)
                .setCancelText("")
                .setCancelColor(Color.parseColor("#f2fafa"))
                .setBgColor(Color.parseColor("#f2fafa"))
                .setContentTextSize(18)
                .setLineSpacingMultiplier(2)
                .setTextColorCenter(Color.BLACK)
                .setDividerType(WheelView.DividerType.FILL)
                .setSubCalSize(14)
                .setSubmitText("完成")
                .setSubmitColor(Color.parseColor("#81C0FE"))
                .isDialog(false)
                .build();
        mPickerView.setPicker(collegeItems,departmentItems);
        mPickerView.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                int position1 = mPickerView.getOption1();
                int position2 = mPickerView.getOption2();
              //  binding.setVariable(BR.special_2017_the_hardest_object_college,collegeItems.get(position1));
              //  binding.setVariable(BR.special_2017_the_hardest_object_major,departmentItems.get(position1).get(position2));
                yellowCircleView.setPercent((int) (mData.get(position1).getMajor().get(position2).getCourse().get(0).getRatio()*100));
                greenCircleView.setPercent((int) (mData.get(position1).getMajor().get(position2).getCourse().get(1).getRatio()*100));
                blueCircleView.setPercent((int) (mData.get(position1).getMajor().get(position2).getCourse().get(2).getRatio()*100));

            }
        });
    }
    public class Presenter implements Presenterable{
        public void onClick(){
            mPickerView.show();
        }
    }
}
