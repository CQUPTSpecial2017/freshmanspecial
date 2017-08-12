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
import com.mredrock.freshmanspecial.data.SexRatio;
import com.mredrock.freshmanspecial.httptools.RatioData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class ManAndWoman extends Fragment  {
    private ViewDataBinding binding;
    private Special_2017_MyCircleView redCircleView;
    private Special_2017_MyCircleView blueCircleView;
    private OptionsPickerView mPickerView;
    private ArrayList<SexRatio> mSexRatios = new ArrayList<>();
    private Subscriber<ArrayList<SexRatio>> mSubscriber;
    private ArrayList<String> optionItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_man_and_woman,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RatioData.getInstance().getSexRatio(new Subscriber<List<SexRatio>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
        e.printStackTrace();
            }

            @Override
            public void onNext(List<SexRatio> sexRatios) {
                mSexRatios.addAll(sexRatios);
                initOptionItem();
            }
        },"SexRatio");


        initOptionPicker();
        binding.setVariable(BR.special_2017_man_and_woman_presenter,new ManAndWoman.Presenter());
        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_man_and_woman_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#b9e7fe","#7ac9eb","#f8fdfe","#ccf5ff","#a5e1fe","#c2eafe"));
        redCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_man_and_woman_red);
        redCircleView.setCircle(new Special_2017_Circle(80,0,"#FFD2E3","#ffabc8","#fffeff","#fff4f5","#fec8db","#fedde9"));
    }
    public void initOptionItem(){
        for (int i = 0; i <mSexRatios.size() ; i++) {
            optionItems.add( mSexRatios.get(i).getCollege());
        }
    }
    public void initOptionPicker(){
        mPickerView = new OptionsPickerView.Builder(this.getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {


                binding.invalidateAll();
            }
        }).setLayoutRes(R.layout.pickerview_academy, new CustomListener() {
            @Override
            public void customLayout(View v) {

            }
        })
                .setTitleBgColor(Color.parseColor("#f2fafa"))
                .setContentTextSize(16)
                .setCancelText("")
                .setCancelColor(Color.parseColor("#f2fafa"))
                .setBgColor(Color.parseColor("#ffffff"))
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
        mPickerView.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                int position = mPickerView.getOption1();
                binding.setVariable(BR.special_2017_man_and_woman_academy,mSexRatios.get(position).getCollege());

                blueCircleView.setPercent((int) (mSexRatios.get(position).getMenRatio()*100));
                blueCircleView.startAnimation();
                redCircleView.setPercent(100 - (int) (mSexRatios.get(position).getMenRatio()*100));
                redCircleView.startAnimation();
                binding.invalidateAll();
            }
        });
    }
    public class Presenter implements Presenterable {
        public void onClick(){
            mPickerView.show();
        }
    }

}
