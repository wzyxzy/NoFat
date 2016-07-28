package com.wzy.nofat.fragment;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import com.wzy.nofat.R;
import com.wzy.nofat.activitys.ChouJiangActivity;
import com.wzy.nofat.activitys.FragmentTwoViewActivity;
import com.wzy.nofat.adapters.RecyclerViewAdapter;
import com.wzy.nofat.model.RecyclerViewModel;
import com.wzy.nofat.url.HttpUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.xutils.http.RequestParams;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by Administrator on 16-4-11.
 */
public class ViewPagerFragmentTwo extends Fragment implements RecyclerViewAdapter.SetOnClickListener, View.OnClickListener {

    //比listView和GridView更灵活的第三方控件
    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpager_fragment_two, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.viewpager_fragment_PtlistView);
         view.findViewById(R.id.viewpager_fragment_two_iv).setOnClickListener(this);
        initView();
        initData();
        return view;
    }

    private void initData() {
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, HttpUrl.PATH_FRAGMENT_TWO_URL,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONArray typelist = new JSONObject(response).getJSONArray("typelist");
                            Gson gson=new Gson();
                            Type type=new TypeToken<List<RecyclerViewModel>>(){}.getType();
                            List<RecyclerViewModel> data=gson.fromJson(typelist.toString(),type);
                            adapter.addList(data);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private void initView() {
        adapter=new RecyclerViewAdapter(null,getContext());
        //实例化布局管理器
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        //设置布局管理器重向
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(manager);
        //绑定适配器
        recyclerView.setAdapter(adapter);

        //初始化借口
        adapter.initView(this);
    }

    //实现借口方法
    public void onItmemClick(int postion,String title) {
        Toast.makeText(getContext(),postion+"",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getContext(), FragmentTwoViewActivity.class);
        intent.putExtra("id",postion);
        intent.putExtra("title",title);
        startActivity(intent);
    }
    //imageView的点击事件
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.viewpager_fragment_two_iv:
                Intent intent=new Intent(getContext(), ChouJiangActivity.class);
                startActivity(intent);
                break;
        }
    }
}
