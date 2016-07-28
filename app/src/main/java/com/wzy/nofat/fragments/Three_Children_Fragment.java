package com.wzy.nofat.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wzy.nofat.R;
import com.wzy.nofat.adapters.ThreeAdapter;
import com.wzy.nofat.model.Tikongcan;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Three_Children_Fragment extends Fragment {

    private RequestQueue queue;
    private List<Tikongcan.PromptListEntity> promptListEntities;
    private List<Tikongcan.StuffListEntity> stuffListEntities;
    private List<Tikongcan.RecipeListEntity> recipeListEntities;
    private ThreeAdapter adapter;
    /** 设置最大访问网络次数 */
    public static final int DEFAULT_MAX_RETRIES = 1;

    /** 设置默认返回次数 */
    public static final float DEFAULT_BACKOFF_MULT = 1f;
    private String path;
    private RecyclerView three_recyclerView;
    private String date;
    public Three_Children_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_three__children_, container, false);
        date = getArguments().getString("date");
        path = "http://bcp.525happy.com/tikong/list?version=510&appkey=10001&date=" + date + "&fid=0";
        initView(layout);
        initData();
        return layout;
    }

    private void initData() {

        queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("res", response.toString());
                initGson(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("gson-result", error.toString());

            }
        });
        //设置延时500秒
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(500000,
                DEFAULT_MAX_RETRIES,
                DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjectRequest);
    }

    private void initGson(String response) {
        Gson gson = new Gson();
        Tikongcan tikongcan = gson.fromJson(response, Tikongcan.class);
        promptListEntities=new ArrayList<>();
        stuffListEntities=new ArrayList<>();
        recipeListEntities=new ArrayList<>();
        promptListEntities = tikongcan.getPromptList();
        stuffListEntities = tikongcan.getStuffList();
        recipeListEntities = tikongcan.getRecipeList();
        adapter = new ThreeAdapter(getContext(),promptListEntities, stuffListEntities, recipeListEntities);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        three_recyclerView.setLayoutManager(linearLayoutManager);
        three_recyclerView.setAdapter(adapter);
//        adapter.updateRes(promptListEntities, stuffListEntities, recipeListEntities);
    }

    private void initView(View layout) {
        three_recyclerView = (RecyclerView) layout.findViewById(R.id.three_recyclerView);




    }
}
