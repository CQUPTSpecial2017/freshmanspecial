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


import com.mredrock.freshmanspecial.Model.Special_2017_Circle;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Fragment.Presenterable.Presenterable;
import com.mredrock.freshmanspecial.Ui.View.MyPickerView.OptionsPickerView;
import com.mredrock.freshmanspecial.Ui.View.MyPickerView.lib.WheelView;
import com.mredrock.freshmanspecial.Ui.View.Special_2017_MyCircleView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class TheHardestObject extends Fragment {
    ViewDataBinding binding;
    Special_2017_MyCircleView yellowCircleView;
    Special_2017_MyCircleView greenCircleView;
    Special_2017_MyCircleView blueCircleView;
    private OptionsPickerView mPickerView;
    private ArrayList<String> academyItems;
    private ArrayList<String> departmentItems;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_the_hardest_object,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initOptionItems();
        initOptionPicker();
        yellowCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_yellow);
        yellowCircleView.setCircle(new Special_2017_Circle(100,0,"#FBFEB9","#f1e28c","#fffffb","#fbf9e3","#fcfaa2"));
        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#B9E5FE","#7ac9eb","#f8fdfe","#ccf5ff","#a6eaff"));
        greenCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_the_hardest_object_green);
        greenCircleView.setCircle(new Special_2017_Circle(80,0,"#9dfced","#6de9d7","#f8fffe","#d7fff7","#86fae8"));
    }
    public class Presenter implements Presenterable{
        public void onClick(){
            mPickerView.show();
        }
    }

    public void initOptionItems(){
        academyItems = new ArrayList<>();
        academyItems.add("计算机");
        academyItems.add("自动化");
        academyItems.add("通信");
        academyItems.add("传媒");
        academyItems.add("光电");
        academyItems.add("软件");

    }
    public void initOptionPicker(){
        mPickerView = new OptionsPickerView.Builder(this.getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = academyItems.get(options1);

                if (tx.equals("计算机")){
                    blueCircleView.setPercent(40);
                    blueCircleView.startAnimation();
                    greenCircleView.setPercent(54);
                    greenCircleView.startAnimation();
                }
                binding.invalidateAll();
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
        mPickerView.setPicker(academyItems);
    }

}
