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
import com.mredrock.freshmanspecial.data.WorkRatio;
import com.mredrock.freshmanspecial.httptools.RatioData;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class WorkPercent extends Fragment {
    private ViewDataBinding binding;
    private OptionsPickerView mPickerView;
    private Special_2017_MyCircleView greenCircleView;
    private Special_2017_MyCircleView blueCircleView;
    private ArrayList<WorkRatio> mWorkRatios  = new ArrayList<>();
    private Subscriber<ArrayList<WorkRatio>> mSubscriber;
    private ArrayList<String> optionItems = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_special_2017_work_percent,container,false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RatioData.getInstance().getWorkRatio(new Subscriber<List<WorkRatio>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
   e.printStackTrace();
            }

            @Override
            public void onNext(List<WorkRatio> workRatios) {
                mWorkRatios.addAll(workRatios);
                initOptionItems();
                Log.d("WorkPercent",mWorkRatios.get(0).getCollege());
            }
        },"WorkRatio");

        initOptionPicker();


        binding.setVariable(BR.special_2017_work_percent_presenter,new Presenter());


        blueCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_work_percent_blue);
        blueCircleView.setCircle(new Special_2017_Circle(60,0,"#b9e7fe","#7ac9eb","#f8fdfe","#ccf5ff","#a5e1fe","#c2eafe"));
        greenCircleView = (Special_2017_MyCircleView)binding.getRoot().findViewById(R.id.special_2017_data_work_percent_green);
        greenCircleView.setCircle(new Special_2017_Circle(80,0,"#9EFCEE","#6decd6","#f8fffe","#defffa","#81f9e8","#a8fef0"));

    }

    public void initOptionItems(){
        for (int i = 0; i <mWorkRatios.size() ; i++) {
           optionItems.add( mWorkRatios.get(i).getCollege());
        }

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
                .setTitleBgColor(Color.WHITE)
                .setCancelText("")
                .setCancelColor(Color.WHITE)
                .setBgColor(Color.WHITE)
                .setContentTextSize(16)
                .setLineSpacingMultiplier(2)
                .setTextColorCenter(Color.WHITE)
                .setDividerType(WheelView.DividerType.FILL)
                .setSubCalSize(17)
                .setSubmitText("完成")
                .setSubmitColor(Color.parseColor("#81C0FE"))
                .isDialog(false)
                .build();
        mPickerView.setPicker(optionItems);
        mPickerView.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                int position = mPickerView.getOption1();
                binding.setVariable(BR.special_2017_work_percent_academy,mWorkRatios.get(position).getCollege());

                    blueCircleView.setPercent(100 - (int) (Float.parseFloat(mWorkRatios.get(position).getRatio())*100));
                    blueCircleView.startAnimation();
                    greenCircleView.setPercent((int) (Float.parseFloat(mWorkRatios.get(position).getRatio())*100));
                    greenCircleView.startAnimation();
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
