package com.wzy.nofat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wzy.nofat.R;
import com.wzy.nofat.activitys.FragmentTwoActivity;

import com.wzy.nofat.adapters.SodukuGridView;
import com.wzy.nofat.adapters.TwoFragmentGridViewAdapter;
import com.wzy.nofat.adapters.ViewPagerFragmentOneAdapter;
import com.wzy.nofat.model.TwoFragmentGridData;
import com.wzy.nofat.model.TwoFragmentModel;
import com.wzy.nofat.url.HttpUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 16-4-11.
 */
public class ViewPagerFragmentOne extends Fragment implements AdapterView.OnItemClickListener,PullToRefreshBase.OnRefreshListener2<ListView>,TwoFragmentGridViewAdapter.OnClickListenerImageView {

    private PullToRefreshListView pullToRefreshListView;
    private ListView listView;
    private ViewPagerFragmentOneAdapter adapter;
    private SodukuGridView gridView;
    private TwoFragmentGridViewAdapter gridAdapter;
    //数据源的页数
    private int position=1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpager_fragment_one,container,false);
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.viewpager_fragment_one_listView);
        initView();
        initData(HttpUrl.PATH_FRAGMENT_TWO, "1", "list");
        initData(HttpUrl.PATH_FRAGMENT_TWO, "1", "hot");
        return view;
    }
    //初始化数据源
    private void initData(String url,String page,final String list) {
        RequestParams params=new RequestParams(url);
       // version=510&appkey=10001&version=1.0&page=1&pageSize=10
        params.addQueryStringParameter("version","510");
        params.addQueryStringParameter("appkey","10001");
        params.addQueryStringParameter("version","1.0");
        params.addQueryStringParameter("page",page);
        params.addQueryStringParameter("pageSize","10");
        x.http().get(params, new Callback.CommonCallback<String>() {
            public void onSuccess(String result) {
                try {
                    //json简析
                    JSONArray hot = new JSONObject(result).getJSONArray(list);
                    Gson gson=new Gson();
                    if(list.equals("list")){
                        Type type=new TypeToken<List<TwoFragmentModel>>(){}.getType();
                        List<TwoFragmentModel> data=gson.fromJson(hot.toString(),type);
                        adapter.addRes(data);
                    }else  if(list.equals("hot")){
                        Type type=new TypeToken<List<TwoFragmentGridData>>(){}.getType();
                        List<TwoFragmentGridData> data=gson.fromJson(hot.toString(),type);
                        gridAdapter.addRes(data);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("baidu", "onError");
            }
            public void onCancelled(CancelledException cex) {

            }
            public void onFinished() {
                //设置刷新完成
                pullToRefreshListView.onRefreshComplete();
            }
        });
    }
    //初始化View
    private void initView() {
        //导入自己定义的View
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_two_view_grid, null);
        //实例化GridView
        gridView= (SodukuGridView) view.findViewById(R.id.fragment_two_view_gridView);
        //给GridView绑定适配器
        gridAdapter=new TwoFragmentGridViewAdapter(getContext(),null,R.layout.fragment_two_view_layout,this);
        gridView.setAdapter(gridAdapter);

        //实例化ListView
        listView=pullToRefreshListView.getRefreshableView();
        //把View添加到ListView
        listView.addHeaderView(view);
        //设置刷新的模式，只下拉加载，不上啦刷新
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        //绑定适配器

        adapter=new ViewPagerFragmentOneAdapter(null,getContext(),R.layout.fragemtn_two_view_layout_data);
        listView.setAdapter(adapter);
        //给listView设置点击事件
        listView.setOnItemClickListener(this);
        //给pullToRefreshListView设置点击事件
        pullToRefreshListView.setOnRefreshListener(this);
    }

    //ListView的点击事件
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("baidu", position + ":::"+view.getId()+";;;;"+R.id.fragment_two_view_layout_ivone);
        Intent intent = new Intent(getContext(), FragmentTwoActivity.class);
        intent.putExtra("url", adapter.getItem(position - 2).getContent());
        intent.putExtra("title", adapter.getItem(position - 2).getTitle());
        intent.putExtra("desc", adapter.getItem(position - 2).getDesc());
        startActivity(intent);
    }
    //pullToRefreshListView的点击事件
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

    }
    //上啦加载的回调
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        position++;
        String page=String.valueOf(position);
        initData(HttpUrl.PATH_FRAGMENT_TWO,page,"list");

    }
    //实现借口的方法
    public void onClick(int position) {
        Intent intent = new Intent(getContext(),FragmentTwoActivity.class);
        intent.putExtra("url", gridAdapter.getItem(position).getContent());
        intent.putExtra("title",gridAdapter.getItem(position).getTitle());
        intent.putExtra("desc", gridAdapter.getItem(position).getDesc());
        startActivity(intent);
    }
}
