package com.example.zhanggang.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 类作用：recyclerview的适配器
 * 时  间：2017/8/30 - 19:02.
 * 创建人：张刚
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;

    public RecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder mholder = (ViewHolder) holder;
            mholder.title.setText(list.get(position));
            //赋值 图片
            if (position % 2 == 1) {
                mholder.imageView.setImageResource(R.drawable.manong);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //内部类ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textview);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
