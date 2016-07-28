package com.wzy.nofat.activitys;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;

import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wzy.nofat.R;
import com.wzy.nofat.adapters.FragmentSendActivity;
import com.wzy.nofat.model.TwoFragmentActivityModel;
import com.wzy.nofat.url.HttpUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FragmentTwoViewActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivReturn;
    private ImageView ivYes;
    private ImageView ivNo;
    private TextView tvContent;
    private TextView tvYes;
    private TextView tvNo;
    private TextView tvPosition;
    private TextView tvCount;
    private TextView tvLeQuan;
    private TextView tvGeShu;
    private TextView  tv;
    private TextView  tv1;
    private int yesPosition=0;//对的次数
    private int noPosition=0;//错误的次数
    private int position=0;//标记显示的内容
    private TextView textView;
    private TextView textView1;
    private String title;
    private int count=1;
    private int select=0;
    private List<TwoFragmentActivityModel> list;
    private View view;
    private View view1;
    private PopupWindow popupWindow;//popupWindow的引用
    private PopupWindow popupWindow1;//popupWindow的引用
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two_view);
        initView();
        initData();
    }

    private void initData() {

        Intent intent=getIntent();
        int id=intent.getIntExtra("id", 0);
        title=intent.getStringExtra("title");
        tvContent.setText(title);//显示内容

        RequestQueue queue= Volley.newRequestQueue(this);

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, HttpUrl.PATH_FRAGMENT_TWO_PATH + id,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONArray ask = new JSONObject(response).getJSONArray("ask");
                            Gson gson=new Gson();
                            Type type=new TypeToken<List<TwoFragmentActivityModel>>(){}.getType();
                            list=(gson.fromJson(ask.toString(),type));
                            tvCount.setText(list.get(0).getTitle());
                            tvPosition.setText(1+"");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    private void initView() {
        //答题规则
        findViewById(R.id.fragment_two_viewactivity_iv).setOnClickListener(this);
        ivReturn = ((ImageView) findViewById(R.id.fragment_two_viewactivity_image));
        ivYes = ((ImageView) findViewById(R.id.fragment_two_viewactivity_yes));
        ivNo = ((ImageView) findViewById(R.id.fragment_two_viewactivity_no));
        //显示的内容
        tvContent= (TextView) findViewById(R.id.fragment_two_viewactivity_tvContent);
        tvYes= (TextView) findViewById(R.id.fragment_two_viewactivity_tvYes);
        tvNo= (TextView) findViewById(R.id.fragment_two_viewactivity_tvNo);
        //我的乐捐
        tvLeQuan= (TextView) findViewById(R.id.fragment_two_viewactivity_leQuan);
        //乐卷的个数
        tvGeShu= (TextView) findViewById(R.id.fragment_two_viewactivity_leQuan_geshu);
        //答题的个数
        tvPosition= (TextView) findViewById(R.id.fragment_two_viewactivity_tvPosition);
        //题的内容
        tvCount= (TextView) findViewById(R.id.fragment_two_viewactivity_tvContentt);

        ivReturn.setOnClickListener(this);
        ivYes.setOnClickListener(this);
        ivNo.setOnClickListener(this);
        tvLeQuan.setOnClickListener(this);

    }

    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fragment_two_viewactivity_iv://答题规则
                    Intent intentImageView=new Intent(this, FragmentSendActivity.class);
                    startActivity(intentImageView);
                    break;
                case R.id.fragment_two_viewactivity_image://返回键
                    finish();
                    break;
                case R.id.fragment_two_viewactivity_yes://对的按钮
                    if(select<10) {
                        getPopup(v, 0);
                        select++;
                        yesPosition = yesPosition + 1;
                        tvYes.setText(yesPosition + "");
                    }else{
                        Toast.makeText(this,"题已经被您回答完了，你可以去对奖",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.fragment_two_viewactivity_leQuan://我的乐卷
                    Intent intent=new Intent(this,FragmentTwoSendActivityJiao.class);
                    String str=tvGeShu.getText().toString();
                    int geShu=Integer.parseInt(str);
                    if(geShu>0){
                        startActivityForResult(intent, 1);
                    }else {
                        Toast.makeText(this,"奖章个数不足",Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.fragment_two_viewactivity_no://错的按钮
                    if(select<10) {
                        select++;
                        getPopup(v,1);
                        noPosition = noPosition + 1;
                        tvNo.setText(noPosition + "");

                        tvGeShu.setText((noPosition*10)+"");
                    }else{
                        Toast.makeText(this,"题已回答完了,可以去对奖",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.fragemtn_two_popupwidns_textview://点击下一页
                    if(popupWindow!=null) {
                        popupWindow.dismiss();
                        if (count < 10) {
                            tvCount.setText(list.get(count).getTitle());
                            count++;
                            tvPosition.setText(count + "");
                        }
                    }
                    break;
                case R.id.fragemtn_two_popupwidns_tv_two://点击下一页
                    if(popupWindow1!=null) {
                        popupWindow1.dismiss();
                        if (count < 10) {
                            tvCount.setText(list.get(count).getTitle());
                            count++;
                            tvPosition.setText(count + "");

                        }
                    }
                    break;
            }
    }

    //自己定义的popupWindow的方法
    private void getPopup(View v,int select){
        if(select==0){
            if(popupWindow==null){
                //填充布局
                view= LayoutInflater.from(this).inflate(R.layout.fragment_two_popupwinds,null);
                textView= (TextView) view.findViewById(R.id.fragemtn_two_popupwidns_tv);
                tv= (TextView) view.findViewById(R.id.fragemtn_two_popupwidns_textview);
                tv.setOnClickListener(this);

                popupWindow=new PopupWindow();
                //设置View
                popupWindow.setContentView(view);
                popupWindow.setWidth(900);
                popupWindow.setHeight(1100);
                //设置popupWindow居中在手机屏幕的中间
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
            }else {
                //如果正在显示就隐藏
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                }
            }
            textView.setText(list.get(position).getDepict());
            position++;
        }else {
            if(popupWindow1==null){
                view1= LayoutInflater.from(this).inflate(R.layout.fragment_two_popupwinds_two,null);
                textView1= (TextView) view1.findViewById(R.id.fragemtn_two_popupwidns_tv_two1);
                tv1= (TextView) view1.findViewById(R.id.fragemtn_two_popupwidns_tv_two);
                tv1.setOnClickListener(this);

                popupWindow1=new PopupWindow();
                //设置View
                popupWindow1.setContentView(view1);
                popupWindow1.setWidth(900);
                popupWindow1.setHeight(1100);
                //设置popupWindow居中在手机屏幕的中间
                popupWindow1.showAtLocation(v, Gravity.CENTER, 0, 0);
            }else {
                //如果正在显示就隐藏
                if(popupWindow1.isShowing()){
                    popupWindow1.dismiss();
                }else {
                    popupWindow1.showAtLocation(v,Gravity.CENTER,0,0);
                }
            }
            textView1.setText(list.get(position).getDepict());
            position++;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2 ){
            switch (requestCode){
                case 1:
                    String str=tvGeShu.getText().toString();
                    int s=Integer.parseInt(str);
                    tvGeShu.setText((s-10)+"");
            }
        }
    }
}
