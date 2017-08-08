package com.mredrock.freshmanspecial.Ui.Fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class WorkPercent extends Fragment {
    private ViewDataBinding binding;
    private OptionsPickerView mPickerView;
    private Special_2017_MyCircleView greenCircleView;
    private Special_2017_MyCircleView blueCircleView;
    private ArrayList<String> optionItems ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_work_percent,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initOptionItems();
        initOptionPicker();
        binding.setVariable(BR.special_2017_work_percent_presenter,new Presenter());
        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_work_percent_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#b9e7fe","#7ac9eb","#f8fdfe","#ccf5ff","#a6e2ff"));
        greenCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_work_percent_green);
        greenCircleView.setCircle(new Special_2017_Circle(80,0,"#9EFCEE","#6decd6","#f8fffe","#defffa","#86fae8"));

    }

    public void initOptionItems(){
        optionItems = new ArrayList<>();
        optionItems.add("计算机");
        optionItems.add("自动化");
        optionItems.add("通信");
        optionItems.add("传媒");
        optionItems.add("光电");
        optionItems.add("软件");

    }
    public void initOptionPicker(){
        mPickerView = new OptionsPickerView.Builder(this.getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = optionItems.get(options1);

            }
        })      .setLayoutRes(R.layout.pickerview_academy, new CustomListener() {
            @Override
            public void customLayout(View v) {

            }
        })
//                .setTitleBgColor(Color.parseColor("#f2fafa"))
                .setContentTextSize(16)
                .setCancelText("")
                .setCancelColor(Color.parseColor("#f2fafa"))
                .setBgColor(Color.parseColor("#f2fafa"))
                .setContentTextSize(18)
                .setLineSpacingMultiplier(2)
                .setTextColorCenter(Color.WHITE)
                .setDividerType(WheelView.DividerType.FILL)
                .setSubCalSize(14)
//                .setSubmitText("完成")
//                .setSubmitColor(Color.parseColor("#81C0FE"))
                .isDialog(false)
                .build();
        mPickerView.setPicker(optionItems);
        mPickerView.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                String tx = optionItems.get(mPickerView.getOption1());
                binding.setVariable(BR.special_2017_work_percent_academy,tx);
                if (tx.equals("计算机")){
                    blueCircleView.setPercent(40);
                    blueCircleView.startAnimation();
                    greenCircleView.setPercent(54);
                    greenCircleView.startAnimation();
                }
                binding.invalidateAll();
            }
        });
    }
    public class Presenter implements Presenterable{
        public void onClick(){
            mPickerView.show();
        }
    }


}
