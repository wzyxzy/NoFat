package com.wzy.nofat.one_gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/4/13 0013.
 */
public class One_FanHouYuFang_GridView extends GridView {
    public One_FanHouYuFang_GridView(Context context) {
        super(context);
    }

    public One_FanHouYuFang_GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public One_FanHouYuFang_GridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
