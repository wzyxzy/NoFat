package com.wzy.nofat.viewpageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 16-4-11.
 */
public class TwoFragmentViewPager extends FragmentPagerAdapter{
    private List<Fragment> data;
    private List<String> dataText;
    public TwoFragmentViewPager(FragmentManager fm,List<Fragment> data,List<String> dataText) {
        super(fm);
        this.data=data;
        this.dataText=dataText;
    }

    public Fragment getItem(int position) {
        return data.get(position);
    }

    public int getCount() {
        return data!=null?data.size():0;
    }

    //显示顶部导航里面的内容，重写的方法
    public CharSequence getPageTitle(int position) {
        return dataText.get(position);
    }
}
