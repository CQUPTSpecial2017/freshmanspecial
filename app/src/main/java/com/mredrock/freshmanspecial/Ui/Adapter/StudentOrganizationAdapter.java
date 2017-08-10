package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.BeautyAroundCqupt;
import com.mredrock.freshmanspecial.data.DailyLife;
import com.mredrock.freshmanspecial.data.FoodAroundCqupt;
import com.mredrock.freshmanspecial.data.StudentOrganization;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class StudentOrganizationAdapter extends RecyclerView.Adapter<StudentOrganizationAdapter.StudentOrganizationViewHolder> {
    private Context mContext;
    private List<StudentOrganization> mStudentOrganizations = new ArrayList<>();
    private StudentOrganizationViewHolder mViewHolder;

    public List<StudentOrganization> getStudentOrganizations() {
        return mStudentOrganizations;
    }

    public void setStudentOrganizations(List<StudentOrganization> studentOrganizations) {
        mStudentOrganizations = studentOrganizations;
    }

    @Override
    public StudentOrganizationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_student_organization,parent,false);
        mViewHolder = new StudentOrganizationViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentOrganizationViewHolder holder, int position) {
        holder.mStudentOrganization = mStudentOrganizations.get(position);
        holder.title.setText(holder.mStudentOrganization.getTitle());
        holder.content.setText(holder.mStudentOrganization.getContent());
        if (position == mStudentOrganizations.size()){
            holder.distinct.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mStudentOrganizations.size();
    }

    public StudentOrganizationAdapter() {

    }

    public StudentOrganizationAdapter(Context context) {
        mContext = context;
    }

    public StudentOrganizationAdapter(Context context, List<StudentOrganization> studentOrganizations) {
        mContext = context;
        mStudentOrganizations = studentOrganizations;
    }

    class StudentOrganizationViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView distinct;
        private StudentOrganization mStudentOrganization;
        public StudentOrganizationViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_name);
            content = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_content);
            distinct = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_distinct);
        }

    }
}
