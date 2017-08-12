package com.mredrock.freshmanspecial.Ui.Fragment.Strategy;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.QQGroupAdapter;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.httptools.GetDataFromServer;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class QQTeam extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mCollegeRecyclerView;
    private RecyclerView mHomeLoadRecyclerView;
    private RecyclerView mSearchRecyclerView;

    private QQGroupAdapter mCollegeAdapter;
    private QQGroupAdapter mHomeLoadAdapter;
    private QQGroupAdapter mSearchAdapter;

    private LinearLayout collegeContent;
    private LinearLayout searchContent;
    private LinearLayout homeLoadContent;
    private ArrayList<String> mSearchResult = new ArrayList<>();
    private TextView cancel ;
    private CardView search ;
    private Context mContext ;
    private EditText searchEdit;
    private Subscriber<QQGroupNumber> mSubscreber;
    private ArrayList<QQGroupNumber> mNumbers = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_qq_group,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        mSubscreber = new Subscriber<QQGroupNumber>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(QQGroupNumber qqGroupNumber) {
                mNumbers.add(qqGroupNumber);
                mCollegeAdapter.setCollegeBeen(mNumbers.get(0).getCollege());

                mHomeLoadAdapter.setHomelandBeen(mNumbers.get(0).getHomeland());
                mSearchAdapter.setSearchResults(mSearchResult);

            }
        };
        GetDataFromServer.getInstance().getQQgroupNumber(mSubscreber,"QQGroupNumber");



        collegeContent = (LinearLayout)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_college_content) ;
        homeLoadContent = (LinearLayout)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_home_load_content) ;
        searchContent = (LinearLayout)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_content) ;

        searchEdit = (EditText)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_edit);
        cancel =  (TextView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_cancel);
        mContext = getContext();
        search  = (CardView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchContent.setVisibility(View.VISIBLE);
                collegeContent.setVisibility(View.GONE);
                homeLoadContent.setVisibility(View.GONE);
                cancel.setVisibility(View.VISIBLE);
            }
        });
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               searchContent.setVisibility(View.GONE);
               collegeContent.setVisibility(View.VISIBLE);
               homeLoadContent.setVisibility(View.VISIBLE);
               cancel.setVisibility(View.GONE);
           }
       });

        mCollegeRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_college_recycle);
        mCollegeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mHomeLoadRecyclerView=(RecyclerView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_home_load_recycle);
        mHomeLoadRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mSearchRecyclerView = (RecyclerView)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_recycle);
        mSearchRecyclerView .setLayoutManager(new LinearLayoutManager(mContext));
        mCollegeAdapter = new QQGroupAdapter(mContext);
        mHomeLoadAdapter = new QQGroupAdapter(mContext);
        mSearchAdapter = new QQGroupAdapter(mContext);



        mHomeLoadRecyclerView.setAdapter(mHomeLoadAdapter);
        mCollegeRecyclerView.setAdapter(mCollegeAdapter);
        mSearchRecyclerView.setAdapter(mSearchAdapter);

        super.onActivityCreated(savedInstanceState);
    }
}
