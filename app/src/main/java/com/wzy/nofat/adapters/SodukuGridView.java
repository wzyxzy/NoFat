package com.wzy.nofat.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 自己定义一个类，继续GridView
 */
public class SodukuGridView extends GridView {
    public SodukuGridView(Context context) {
        super(context);
    }

    public SodukuGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SodukuGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写这个方法
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
