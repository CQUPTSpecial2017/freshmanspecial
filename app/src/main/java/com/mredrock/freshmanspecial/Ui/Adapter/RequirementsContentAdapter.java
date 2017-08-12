package com.mredrock.freshmanspecial.Ui.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class RequirementsContentAdapter extends RecyclerView.Adapter<RequirementsContentAdapter.RequirementsContentViewHolder> {
    private ArrayList<RequirementTitle.RequirementContent> mContent= new ArrayList<>();
    private RequirementsContentViewHolder mViewHolder ;

    public RequirementsContentAdapter(ArrayList<RequirementTitle.RequirementContent> content) {
        mContent = content;
    }

    public RequirementsContentAdapter() {

    }

    @Override
    public RequirementsContentAdapter.RequirementsContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_requirement_content,parent,false);
        mViewHolder = new RequirementsContentViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RequirementsContentAdapter.RequirementsContentViewHolder holder, int position) {
        SpannableStringBuilder style = new SpannableStringBuilder(mContent.get(position).getTitle()+mContent.get(position).getContent());
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#65B2FF")), 0, mContent.get(position).getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.content.setText(style);

    }

    @Override
    public int getItemCount() {
        return mContent.size();
    }

    class RequirementsContentViewHolder extends RecyclerView.ViewHolder{
        TextView content;
        public RequirementsContentViewHolder(View itemView) {
            super(itemView);
            content = (TextView)itemView.findViewById(R.id.item_requirement_content_content);
        }
    }
}
