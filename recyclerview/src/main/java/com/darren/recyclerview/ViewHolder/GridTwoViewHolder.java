package com.darren.recyclerview.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.darren.recyclerview.R;
import com.darren.recyclerview.View.RectImageView;

/**
 * Created by lenovo on 2017/12/14.
 */

public class GridTwoViewHolder extends RecyclerView.ViewHolder {
    public RectImageView iv_icon;
    public TextView tv_content;
    public GridTwoViewHolder(View itemView) {
        super(itemView);
        iv_icon = (RectImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }
}
