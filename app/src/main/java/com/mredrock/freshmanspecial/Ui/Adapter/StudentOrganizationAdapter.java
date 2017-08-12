package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import com.mredrock.freshmanspecial.data.Organizations;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class StudentOrganizationAdapter extends RecyclerView.Adapter<StudentOrganizationAdapter.StudentOrganizationViewHolder> {
    private Context mContext;
    private List<Organizations> mOrganizationses = new ArrayList<>();
    private StudentOrganizationViewHolder mViewHolder;

    public List<Organizations> getStudentOrganizations() {
        return mOrganizationses;
    }

    public void setStudentOrganizations(List<Organizations> organizationses) {
        mOrganizationses = organizationses;
    }

    @Override
    public StudentOrganizationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_student_organization,parent,false);
        mViewHolder = new StudentOrganizationViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentOrganizationViewHolder holder, int position) {
        if (mOrganizationses.size()!= 0){
        holder.mDepartmentBean = mOrganizationses.get(0).getDepartment().get(position);
        holder.title.setText(holder.mDepartmentBean.getName());
        holder.content.setText(holder.mDepartmentBean.getResume());
        if (position == 0){
            holder.distinct.setVisibility(View.GONE);
        }
        }
    }

    @Override
    public int getItemCount() {
        return mOrganizationses.size();
    }

    public StudentOrganizationAdapter() {

    }

    public StudentOrganizationAdapter(Context context) {
        mContext = context;
    }

    public StudentOrganizationAdapter(Context context, List<Organizations> organizationses) {
        mContext = context;
        mOrganizationses = organizationses;
    }

    class StudentOrganizationViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView distinct;
        private Organizations.DepartmentBean mDepartmentBean;
        public StudentOrganizationViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_name);
            content = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_content);
            distinct = (TextView)itemView.findViewById(R.id.item_special_2017_student_organization_distinct);
        }

    }
}
