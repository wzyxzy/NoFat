package com.wzy.nofat.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoJsonModel;

import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import io.vov.vitamio.widget.VideoView;

public class FragmentTwoSendActivityJiao extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private VideoView videoView;
    private TextView tv;
    private TextView tv1;
    private ListView listView;
    private AlertDialog alertDialog;
    private List<TwoJsonModel> data;

    private ImageView iv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_two_send_activity_jiao);
        initView();
        initData();

    }

    private void initData() {
        View view=LayoutInflater.from(this).inflate(R.layout.fragment_two_dianying, null);
        tv = ((TextView)view. findViewById(R.id.fragment_two_button));
        tv1 = ((TextView)view. findViewById(R.id.fragment_two_button_one));
        iv= (ImageView) findViewById(R.id.fragment_two_return);
         alertDialog=new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();
        tv1.setOnClickListener(this);
        tv.setOnClickListener(this);
        iv.setOnClickListener(this);
    }

    private void initView() {
        listView= (ListView) findViewById(R.id.fragment_two_activity_listView);
        listView.setOnItemClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_two_button:
                List<String> list=new ArrayList<>();
                alertDialog.dismiss();
                data=getJson();
                for(int i=0;i<data.size();i++){
                    String title=data.get(i).getTitle();
                    list.add(title);
                 }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                       android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);

                break;
            case R.id.fragment_two_button_one:
                alertDialog.dismiss();
                finish();
                break;
            case R.id.fragment_two_return:
                finish();
                break;
        }
    }

    //获得json字符串
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getResources().getAssets().open("jao.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    //简析字符串的方法
    public List<TwoJsonModel> getJson(){
        String json=loadJSONFromAsset();
        try {
            JSONArray tv_list = new JSONObject(json).getJSONArray("tv_list");
            Gson gson=new Gson();
            Type type=new TypeToken<List<TwoJsonModel>>(){}.getType();
            List<TwoJsonModel> data=gson.fromJson(tv_list.toString(),type);
            return data;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //listView的点击事件
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Intent intent1=new Intent();
         setResult(2, intent1);


        Intent intent=new Intent(this,VideoViewActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("url", data.get(position).getUrl());
        bundle.putParcelableArrayList("data",(ArrayList<TwoJsonModel>) data);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}






