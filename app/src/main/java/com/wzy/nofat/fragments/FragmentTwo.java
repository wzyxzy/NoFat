package com.wzy.nofat.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wzy.nofat.R;
import com.wzy.nofat.activitys.FragmentTwoTitleActivity;
import com.wzy.nofat.fragment.ViewPagerFragmentOne;
import com.wzy.nofat.fragment.ViewPagerFragmentTwo;
import com.wzy.nofat.viewpageradapter.TwoFragmentViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 第二个fragment
 */
public class FragmentTwo extends Fragment implements View.OnClickListener {
    //上啦刷新与下载
    private ViewPager viewPager;
    //顶部导航
    private TabLayout tabLayout;
    //初始化化LierarLayout
    private LinearLayout linearLayout;

    TwoFragmentViewPager adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        linearLayout = (LinearLayout) layout.findViewById(R.id.fragment_two_linearLayout);
        tabLayout= (TabLayout) layout.findViewById(R.id.fragment_two_tabLayout);
        viewPager= (ViewPager) layout.findViewById(R.id.fragment_two_viewPager);
        linearLayout.setOnClickListener(this);
        initData();
        return layout;
    }
    private void initData() {

        List<Fragment> data=new ArrayList<>();
        data.add(new ViewPagerFragmentOne());
        data.add(new ViewPagerFragmentTwo());

        //TabLayout的数据源
        List<String> dataText=new ArrayList<>();
        dataText.add("享瘦百科");
        dataText.add("有奖问答");

        //绑定适配器
        adapter=new TwoFragmentViewPager(getChildFragmentManager(),data,dataText);
        viewPager.setAdapter(adapter);

        //绑定TabLayout与ViewPager联动
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_two_linearLayout:
                Intent intent=new Intent(getActivity(), FragmentTwoTitleActivity.class);
                startActivity(intent);
                break;

        }
    }
}
