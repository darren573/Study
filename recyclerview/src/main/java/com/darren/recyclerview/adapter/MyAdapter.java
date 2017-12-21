package com.darren.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.recyclerview.Bean.Music;
import com.darren.recyclerview.Listener.OnItemClickListener;
import com.darren.recyclerview.R;
import com.darren.recyclerview.ViewHolder.GridThreeViewHolder;
import com.darren.recyclerview.ViewHolder.GridTwoViewHolder;
import com.darren.recyclerview.ViewHolder.ListViewHolder;
import com.darren.recyclerview.ViewHolder.TitleViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/12/14.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private List<Music> mList;
    private Context mContext;
    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public MyAdapter(Context context, List<Music> list) {
        this.mList = list;
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder mViewHolder = null;
        if (viewType == Music.TYPE.TYPE_GRID_THREE) {
            view = inflater.inflate(R.layout.item_grid_three, parent, false);
            mViewHolder = new GridThreeViewHolder(view);
        } else if (viewType == Music.TYPE.TYPE_GRID_TWO) {
            view = inflater.inflate(R.layout.item_grid_two, parent, false);
            mViewHolder = new GridTwoViewHolder(view);
        } else if (viewType == Music.TYPE.TYPE_LIST) {
            view = inflater.inflate(R.layout.item_list, parent, false);
            mViewHolder = new ListViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.item_title, parent, false);
            mViewHolder = new TitleViewHolder(view);
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Music.TYPE.TYPE_GRID_THREE:
                GridThreeViewHolder gridThreeViewHolder = (GridThreeViewHolder) holder;
                gridThreeViewHolder.iv_icon.setImageResource(mList.get(position).imageId);
                gridThreeViewHolder.tv_content.setText(mList.get(position).title);
                //点击事件
                gridThreeViewHolder.itemView.setOnClickListener(this);
                //设置TAG 防止错位
                gridThreeViewHolder.itemView.setTag(position);
                break;
            case Music.TYPE.TYPE_GRID_TWO:
                GridTwoViewHolder gridTwoViewHolder = (GridTwoViewHolder) holder;
                gridTwoViewHolder.iv_icon.setImageResource(mList.get(position).imageId);
                gridTwoViewHolder.tv_content.setText(mList.get(position).title);
                //点击事件
                gridTwoViewHolder.itemView.setOnClickListener(this);
                //设置TAG 防止错位
                gridTwoViewHolder.itemView.setTag(position);
                break;
            case Music.TYPE.TYPE_LIST:
                ListViewHolder listViewHolder = (ListViewHolder) holder;
                listViewHolder.iv_icon.setImageResource(mList.get(position).imageId);
                listViewHolder.tv_content.setText(mList.get(position).title);
                //点击事件
                listViewHolder.itemView.setOnClickListener(this);
                //设置TAG 防止错位
                listViewHolder.itemView.setTag(position);
                break;
            case Music.TYPE.TYPE_TITLE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                titleViewHolder.iv_content.setText(mList.get(position).title);
                //点击事件
                titleViewHolder.itemView.setOnClickListener(this);
                //设置TAG 防止错位
                titleViewHolder.itemView.setTag(position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            int position = (int) v.getTag();
            mOnItemClickListener.OnItemClick(position);
        }
    }
}
