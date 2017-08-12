package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Ui.Special_2017_ImageClickActivity;
import com.mredrock.freshmanspecial.data.ExcellentStudent;
import com.mredrock.freshmanspecial.data.ExcellentTeacher;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class ExcellentTeacherAdapter extends RecyclerView.Adapter<ExcellentTeacherAdapter.TeacherViewHolder>{
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<ExcellentTeacher> mTeachers = new ArrayList<>();
    private List<ExcellentStudent> mStudents = new ArrayList<>();

    private int type;
    private TeacherViewHolder mViewHolder;

    public ExcellentTeacherAdapter(Context context) {
        mContext = context;

    }

    public List<ExcellentTeacher> getTeachers() {
        return mTeachers;
    }

    public void setTeachers(List<ExcellentTeacher> teachers) {
        mTeachers = teachers;
        type = 1;
    }

    public List<ExcellentStudent> getStudents() {
        return mStudents;
    }

    public void setStudents(List<ExcellentStudent> students) {
        mStudents = students;
        type = 0;
    }

    public ExcellentTeacherAdapter() {


    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_excellent_teachers,parent,false);
        mViewHolder = new TeacherViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        if (type ==1 ) {
            holder.mTeacher = mTeachers.get(position);
            holder.name.setText(holder.mTeacher.getName());

        }else {
            holder.mStudent = mStudents.get(position);
            holder.name.setText(holder.mStudent.getName());

        }




    }

    @Override
    public int getItemCount() {

        if (type == 1)
            return mTeachers.size();
        else return mStudents.size();
    }




    class TeacherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView major;
        private CircleImageView avatar;
        private ExcellentTeacher mTeacher;
        private ExcellentStudent mStudent;


        public TeacherViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.item_excellent_teachers_name);
            major = (TextView) itemView.findViewById(R.id.item_excellent_teachers_major);
            avatar = (CircleImageView) itemView.findViewById(R.id.item_excellent_teachers_circle_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Special_2017_ImageClickActivity.class);
            if (type == 1){
                intent.putExtra("type","teacher");
                intent.putExtra("teacher",mTeacher);
            }
            else {
                intent.putExtra("type","student");
                intent.putExtra("student",mStudent);
            }
            view.getContext().startActivity(intent);
        }
    }
}
