package com.wzy.nofat.one_gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class One_WZGridView extends GridView {


    public One_WZGridView(Context context) {
        super(context);
    }

    public One_WZGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public One_WZGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//实现scroolview的嵌套gridview的时候显示多个条目问题
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
