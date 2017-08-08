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

public class ManAndWoman extends Fragment  {
    private ViewDataBinding binding;
    private ArrayList<String> optionItems ;
    private Special_2017_MyCircleView redCircleView;
    private Special_2017_MyCircleView blueCircleView;
    private OptionsPickerView mPickerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_man_and_woman,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_man_and_woman_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#b9e7fe","#7ac9eb","#f8fdfe","#ccf5ff","#a6e2ff"));
        redCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_man_and_woman_red);
        redCircleView.setCircle(new Special_2017_Circle(80,0,"#FFD2E3","#ffabc8","#fffeff","#fff4f5","#FFDaE3"));
    }
    public void initOptionPicker(){
        mPickerView = new OptionsPickerView.Builder(this.getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = optionItems.get(options1);

                if (tx.equals("计算机")){
                    blueCircleView.setPercent(40);
                    blueCircleView.startAnimation();
                    redCircleView.setPercent(54);
                    redCircleView.startAnimation();
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
        mPickerView.setPicker(optionItems);
    }
    public class Presenter implements Presenterable {
        public void onClick(){
            mPickerView.show();
        }
    }

}
