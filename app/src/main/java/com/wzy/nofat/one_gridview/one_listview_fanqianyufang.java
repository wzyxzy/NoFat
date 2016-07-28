package com.wzy.nofat.one_gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/4/13 0013.
 */
public class one_listview_fanqianyufang extends ListView {
    public one_listview_fanqianyufang(Context context) {
        super(context);
    }

    public one_listview_fanqianyufang(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public one_listview_fanqianyufang(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int shuju = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, shuju);
    }
}
