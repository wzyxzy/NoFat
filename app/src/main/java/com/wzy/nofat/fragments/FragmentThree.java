package com.wzy.nofat.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wzy.nofat.R;
import com.wzy.nofat.adapters.ThreeViewPagerAdapter;
import com.wzy.nofat.model.Tikongcan;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {

    private RequestQueue queue;
    private List<Tikongcan.SolarDateEntity> solarDateEntities;
    private static final String path = "http://bcp.525happy.com/tikong/list?version=510&appkey=10001";
    private TextView three_title_text;
    private ImageView three_title_img_right;
    private TabLayout three_tabLayout;
    private ViewPager three_viewPager;
    private Tikongcan tikongcan;
    private ThreeViewPagerAdapter adapter;
    /**
     * 设置最大访问网络次数
     */
    public static final int DEFAULT_MAX_RETRIES = 1;

    /**
     * 设置默认返回次数
     */
    public static final float DEFAULT_BACKOFF_MULT = 1f;

    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        // Inflate the layout for this fragment

        initView(layout);
        initData();

        return layout;
    }

    private void initData() {
        queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("gson-result", response.toString());
                initGson(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "更新数据出错,请检查网络环境", Toast.LENGTH_SHORT).show();

            }
        });
        //设置超时
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(500000,
                DEFAULT_MAX_RETRIES,
                DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjectRequest);
    }

    private void initGson(String response) {
        Gson gson = new Gson();
        tikongcan = gson.fromJson(response, Tikongcan.class);
        List<Fragment> data = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 1; i < tikongcan.getSolarDate().size() - 1; i++) {
            Three_Children_Fragment fragment = new Three_Children_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("date", tikongcan.getSolarDate().get(i).getDate());
            fragment.setArguments(bundle);
            data.add(fragment);
            titles.add(tikongcan.getSolarDate().get(i).getLabel());
        }
        adapter = new ThreeViewPagerAdapter(getFragmentManager(), data, titles);
        three_viewPager.setAdapter(adapter);
        three_tabLayout.setupWithViewPager(three_viewPager);
//        three_tabLayout.setScrollPosition(0, 7f, true);
//        three_tabLayout.getSelectedTabPosition();

    }


    private void initView(View layout) {
        three_title_text = (TextView) layout.findViewById(R.id.three_title_text);
        three_tabLayout = (TabLayout) layout.findViewById(R.id.three_tabLayout);
        three_viewPager = (ViewPager) layout.findViewById(R.id.three_viewPager);

    }

}
