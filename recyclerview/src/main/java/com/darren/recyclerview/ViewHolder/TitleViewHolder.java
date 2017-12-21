package com.darren.recyclerview.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.darren.recyclerview.R;

/**
 * Created by lenovo on 2017/12/14.
 */

public class TitleViewHolder extends RecyclerView.ViewHolder {
    public TextView iv_content;

    public TitleViewHolder(View itemView) {
        super(itemView);
        iv_content = (TextView) itemView.findViewById(R.id.iv_content);
    }
}
