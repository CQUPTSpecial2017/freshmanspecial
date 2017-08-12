package com.mredrock.freshmanspecial.Ui.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.data.RequirementTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class QQGroupAdapter extends RecyclerView.Adapter<QQGroupAdapter.QQGroupViewHolder>{
    private ArrayList<String> mStrings = new ArrayList<>();
    private int type;

    private Context mContext;
    private QQGroupAdapter.QQGroupViewHolder mViewHolder ;

    public QQGroupAdapter(Context context) {
        mContext = context;

    }

    public QQGroupAdapter() {

    }

    public ArrayList<String> getStrings() {
        return mStrings;
    }

    public void setStrings(ArrayList<String> strings,int type  ) {
        mStrings = strings;
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public QQGroupAdapter.QQGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_special_2017_qq_group_content,parent,false);
        mViewHolder = new QQGroupAdapter.QQGroupViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(QQGroupAdapter.QQGroupViewHolder holder, final int position) {
        if (type != 0  ){
            if (position == 0 ){
                holder.content.setTextColor(Color.BLACK);
                holder.content.setTextSize(16);
                holder.content.setPadding(2,8,2,8);
            }else if (position == 21){
                holder.content.setTextColor(Color.BLACK);
                holder.content.setTextSize(16);
                holder.content.setPadding(2,8,2,8);
            }else{
                holder.content.setTextColor(Color.parseColor("#999999"));
                holder.content.setTextSize(13);
            }
        }

        holder.content .setText(mStrings.get(position));
        holder.content.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);

                // 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）
                ClipData clipData = ClipData.newPlainText(null, mStrings.get(position));

                // 把数据集设置（复制）到剪贴板
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(mContext,"信息已经复制！",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }



    @Override
    public int getItemCount() {
       return mStrings.size();
    }

    class QQGroupViewHolder  extends RecyclerView.ViewHolder{
        private TextView content ;

        public QQGroupViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.special_2017_qq_group_content);
        }
    }
}
