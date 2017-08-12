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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Adapter.QQGroupAdapter;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.httptools.GetDataFromServe;
import com.mredrock.freshmanspecial.httptools.PostDataToServer;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class QQTeam extends Fragment {
    private ViewDataBinding mDataBinding;
    private RecyclerView mCollegeRecyclerView;
    private RecyclerView mSearchRecyclerView;
    private LinearLayout mSearchContent;
    private boolean isSearching = false;
    private QQGroupAdapter mCollegeAdapter;
    private QQGroupAdapter mSearchAdapter;

    private ArrayList<String> mSearchResult = new ArrayList<>();
    private ArrayList<String> mStrings = new ArrayList<>();

    private TextView cancel ;
    private ImageView cancelImage;
    private ImageView searchImage;
    private String TAG = "QQTeam";
    private CardView search ;
    private Context mContext ;
    private EditText searchEdit;
    private QQGroupNumber mNumber = new QQGroupNumber();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_2017_qq_group,container,false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        GetDataFromServe.getInstance().getQQgroupNumber(new Subscriber<QQGroupNumber>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(QQGroupNumber qqGroupNumber) {
                mNumber =qqGroupNumber;
                mStrings.add("新生群");
                for (int i = 0; i <qqGroupNumber.getCollege().size() ; i++) {
                    mStrings.add(qqGroupNumber.getCollege().get(i).getGroupName()+" : "+qqGroupNumber.getCollege().get(i).getNumber());
                }
                mStrings.add("老乡群");
                for (int i = 0; i <qqGroupNumber.getHomeland().size() ; i++) {
                    mStrings.add(qqGroupNumber.getHomeland().get(i).getGroupName()+" : "+qqGroupNumber.getHomeland().get(i).getNumber());
                }
                mCollegeAdapter.setStrings(mStrings,1);
                mCollegeAdapter.notifyDataSetChanged();

                Log.d(TAG,qqGroupNumber.getCollege().size()+"");
                Log.d(TAG,qqGroupNumber.getHomeland().size()+"");

            }
        },"QQGroup");

        mSearchContent = (LinearLayout)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_content) ;
        searchEdit = (EditText)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_edit);
        searchImage = (ImageView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_image);
        searchEdit.setMaxLines(1);
        searchEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSearching){
                    mCollegeRecyclerView.setVisibility(View.GONE);
                    mSearchContent.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    cancelImage.setVisibility(View.VISIBLE);
                    searchImage.setVisibility(View.GONE);
                    isSearching = true;
                }

            }
        });
        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getSearch(editable.toString());
                mSearchAdapter.setStrings(mSearchResult,0);
                mSearchAdapter.notifyDataSetChanged();

            }
        });
        cancel =  (TextView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_cancel);
        cancelImage =  (ImageView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_cancel_image);

        mContext = getContext();
        search  = (CardView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSearching){
                    mCollegeRecyclerView.setVisibility(View.GONE);
                    mSearchContent.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    cancelImage.setVisibility(View.VISIBLE);
                    searchImage.setVisibility(View.GONE);
                    isSearching = true;
                }

            }
        });
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (isSearching){
                   mCollegeRecyclerView.setVisibility(View.VISIBLE);
                   mSearchContent.setVisibility(View.GONE);
                   cancel.setVisibility(View.GONE);
                   cancelImage.setVisibility(View.GONE);
                   searchImage.setVisibility(View.VISIBLE);
                   isSearching = false;
                   searchEdit.setText("");
                   mSearchResult.clear();
               }

           }
       });
        cancelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSearching) {
                   searchEdit.setText("");
                }

            }
        });

        mCollegeRecyclerView =(RecyclerView) mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_recycle);
        mCollegeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mSearchRecyclerView = (RecyclerView)mDataBinding.getRoot().findViewById(R.id.special_2017_qq_group_search_recycle);
        mSearchRecyclerView .setLayoutManager(new LinearLayoutManager(mContext));
        mCollegeAdapter = new QQGroupAdapter(mContext);

        mSearchAdapter = new QQGroupAdapter(mContext);

        mCollegeRecyclerView.setAdapter(mCollegeAdapter);
        mSearchRecyclerView.setAdapter(mSearchAdapter);

        super.onActivityCreated(savedInstanceState);
    }

    private void getSearch(String string){
        for (int i = 1; i <mStrings.size() ; i++) {
            if (i == 21)
                continue;
            if (mStrings.get(i).contains(string)){
                mSearchResult.add(mStrings.get(i));
            }
        }

    }
}
