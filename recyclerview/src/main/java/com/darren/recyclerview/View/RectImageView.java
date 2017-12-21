package com.darren.recyclerview.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


/**
 * 长方形图片
 */

public class RectImageView extends android.support.v7.widget.AppCompatImageView {

    public RectImageView(Context context) {
        super(context);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.FIT_XY);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);
        // 设置大小为宽度的三分之二
        int halfWidthMeasureSpec=MeasureSpec.makeMeasureSpec(width/3*2,widthMode);
        super.onMeasure(widthMeasureSpec,halfWidthMeasureSpec);
    }
}
