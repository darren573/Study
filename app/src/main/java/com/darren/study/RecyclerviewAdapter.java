package com.darren.study;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2017/12/13.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private List<Message> mList;

    public RecyclerviewAdapter(List<Message> list) {
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message msg = mList.get(position);
        holder.tv_username.setText(msg.getUsername());
        holder.tv_time.setText(msg.getTime());
        holder.tv_message.setText(msg.getMessage());
        holder.iv_icon.setBackgroundResource(msg.getImg_id());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_username, tv_time, tv_message;
        private ImageView iv_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_message = itemView.findViewById(R.id.tv_message);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
