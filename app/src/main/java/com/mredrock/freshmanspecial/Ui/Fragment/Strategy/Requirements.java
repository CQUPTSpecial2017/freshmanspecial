package com.mredrock.freshmanspecial.Ui.Fragment.Strategy;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.RequirementsAdapter;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class Requirements extends Fragment {
    private ViewDataBinding mDataBinding;
    private TextView register;
    private  TextView register_date;
    private TextView register_thing;
    private TextView wash_suplies;
    private TextView  clothes;
    private TextView my_thing;
    private TextView prevent_deception;
    private TextView cash;
    private TextView refusing_sale;
    private TextView against_theft;
    private TextView Caution_for_fire;
    private TextView Caution_for_translate;
    private TextView safe_warning;
    private TextView route_1;
    private TextView route_2;
    private TextView route_3;
    private TextView route_4;
    private TextView route_5;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_requirements,container,false);

        return mDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        register_date=(TextView)view.findViewById(R.id.register_date) ;
        register_thing=(TextView)view.findViewById(R.id.register_thing) ;
        wash_suplies=(TextView)view.findViewById(R.id.wash_spulies) ;
        my_thing=(TextView)view.findViewById(R.id.my_thing) ;
        clothes=(TextView)view.findViewById(R.id.clothes) ;
        prevent_deception=(TextView)view.findViewById(R.id.prevent_deception);
        cash=(TextView)view.findViewById(R.id.cash);
        refusing_sale=(TextView)view.findViewById(R.id.refusing_sale);
        against_theft=(TextView)view.findViewById(R.id.against_theft);
        Caution_for_fire=(TextView)view.findViewById(R.id.Caution_for_fire) ;
        Caution_for_translate=(TextView)view.findViewById(R.id.Caution_for_traslate) ;
        safe_warning=(TextView)view.findViewById(R.id.safe_warning) ;
        route_1=(TextView)view.findViewById(R.id.route_1) ;
        route_2=(TextView)view.findViewById(R.id.route_2) ;
        route_3=(TextView)view.findViewById(R.id.route_3) ;
        route_4=(TextView)view.findViewById(R.id.route_4) ;
        route_5=(TextView)view.findViewById(R.id.route_5) ;
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#65B2FF"));
        SpannableString spannableString= SpannableString.valueOf("报道时间：本科新生2017年9月14、15日报道");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        register_date.setText(spannableString);
        spannableString= SpannableString.valueOf("报道地点：重庆邮电大学风雨操场");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString= SpannableString.valueOf("新生必带：\t同版近期照片共15张（要求光面相纸洗印，白底一寸，半身，正脸，免冠大头照片），新生档案，党团关系证明，户口本（需要迁户口的同学携带），录取通知书，高考准考证，身份证（建议复印件多复印几份），银行卡（缴学费）,少量现金。");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        register_thing.setText(spannableString);
        spannableString= SpannableString.valueOf("洗护用品：护肤品，剃须刀，日常洗漱需要的物品（诸如牙膏牙刷，毛巾，沐浴露，洗衣液等）");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wash_suplies.setText(spannableString);
        spannableString= SpannableString.valueOf("生活用品：四季的衣物（重庆本地的同学或经常回家的同学携带当季衣服即可），各种晾晒衣物的工具，蚊帐，一些基本的床上用品，凉席，遮光帘（要是对灯光比较敏感，建议准备），一些常用药品，台灯，还有各类寝室神器。");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clothes.setText(spannableString);
        spannableString= SpannableString.valueOf("个人物品:" +"电脑（笔记本最宜，其他的数码产品根据自己的情况进行添置），以及一些学习物品（签字笔，笔记本等等），台灯，水杯等等。\n");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        my_thing.setText(spannableString);
        spannableString= SpannableString.valueOf("防止上当受骗：一些不法分子利用刚入学的新生不熟悉情况，以老师，学长或者老乡的身份骗取新生信任，然后以代费、减免学费等多种方式进行诈骗。");
        spannableString.setSpan(foregroundColorSpan,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        prevent_deception.setText(spannableString);
        spannableString= SpannableString.valueOf("不携带过多现金：数额较大的现金应该及时存入银行，存折、银行卡、身份证尽量分开放；使用银行卡要谨慎以防密码泄露。");
        spannableString.setSpan(foregroundColorSpan,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        cash.setText(spannableString);
        spannableString= SpannableString.valueOf("拒绝上门推销:许多不法分子以到寝室推销为名进行诈骗或盗窃，如若发现上门推销人员，应该及时报告宿管人员或者保卫处。");
        spannableString.setSpan(foregroundColorSpan,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        refusing_sale.setText(spannableString);
        spannableString= SpannableString.valueOf("室内注意防盗:要保管好自己的笔记本电脑、手机等贵重物品，不要将其随意放置，以免被“顺手牵羊”。");
        spannableString.setSpan(foregroundColorSpan,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        against_theft.setText(spannableString);
        spannableString= SpannableString.valueOf("注意消防安全:爱护消防设施，寝室内不违章使用大功率电器。");
        spannableString.setSpan(foregroundColorSpan,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Caution_for_fire.setText(spannableString);
        spannableString= SpannableString.valueOf("注意交通安全:不乘坐“黑车”和存在安全隐患的车辆。");
        spannableString.setSpan(foregroundColorSpan,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Caution_for_translate.setText(spannableString);
        spannableString= SpannableString.valueOf("遇到情况及时与公安机关联系。在遇到不法侵害时,要及时与公安机关（110）或者学校保卫处联系（62461018,62460110）");
        safe_warning.setText(spannableString);
        spannableString= SpannableString.valueOf("迎新接站：报道期间，我校将在重庆火车北站南、北广场设新生接待站，有同学负责引导新生到指定地点乘车");
        spannableString.setSpan(foregroundColorSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        route_1.setText(spannableString);
        spannableString= SpannableString.valueOf("方案二：" +
                "重庆江北机场（距离学校约40公里）：可乘机场大巴至上清寺后转乘108路公交车至南坪，再转乘346或347路公交车到学校；或乘轻轨三号线到南坪，再转乘346或347路公交车到学校；直接打车到校费用约为70元；");
        spannableString.setSpan(foregroundColorSpan,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        route_2.setText(spannableString);
        spannableString= SpannableString.valueOf("方案三：" +
                "龙头寺火车站、重庆北站（距离学校约20公里）：乘323路或168路公交车至南坪，转乘346或347路公交车至学校：或乘轻轨三号线到南坪，再转乘346或347路公交\n" +
                "车到学校；直接打车到校费用约40元；");
        spannableString.setSpan(foregroundColorSpan,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        route_3.setText(spannableString);
        spannableString= SpannableString.valueOf("方案四：" +
                "菜园坝火车站、汽车站（距离学校约12公里）：可在菜园坝广场乘347路公交车至学校；直接打车到校费用约为25元；");
        spannableString.setSpan(foregroundColorSpan,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        route_4.setText(spannableString);
        spannableString= SpannableString.valueOf("方案五：" +
                "朝天门码头（距离学校约9公里）：可乘车至南坪后转乘346或347路公交车至学校；直接打车到校费用约为20元。");
        spannableString.setSpan(foregroundColorSpan,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        route_5.setText(spannableString);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
