package com.wzy.nofat.activitys;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.wzy.nofat.adapters.TwoFragmentTitleAdapter;
import com.wzy.nofat.model.TwoFragmentTitleModel;
import com.wzy.nofat.url.HttpUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.lang.reflect.Type;
import java.util.List;

public class FragmentTwoTitleActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView returnImageView;
    private ImageView qingChuImageView;
    private EditText editText;
    private TextView textView;
    private ListView listView;
    private TwoFragmentTitleAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two_title);
        initView();
    }

    private void initView() {

        returnImageView = ((ImageView) findViewById(R.id.activity_fragment_two_title_imageView_return));
        qingChuImageView= (ImageView) findViewById(R.id.activity_fragment_two_title_imageView);
        editText= (EditText) findViewById(R.id.activity_fragment_two_title_textView_edittext);
        textView= (TextView) findViewById(R.id.activity_fragment_two_title_textView);
        listView= (ListView) findViewById(R.id.activity_fragment_two_title_listView);

        textView.setOnClickListener(this);
        editText.setOnClickListener(this);
        qingChuImageView.setOnClickListener(this);
        returnImageView.setOnClickListener(this);

        adapter=new TwoFragmentTitleAdapter(null,this,R.layout.fragment_two_titl_data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_fragment_two_title_imageView_return:
                //点击返回键销毁
                finish();
                break;
            case R.id.activity_fragment_two_title_imageView:
                editText.setText("");
                break;
            case R.id.activity_fragment_two_title_textView:
                //拿到自己输入的内容
                String url=editText.getText().toString();
                //加载数据,
                //初始化RequestQueue，
                RequestQueue requestQueue=Volley.newRequestQueue(this);
                //第一参数是请求方法，二个url 三请求成功的回调，四 请求失败的回调
                StringRequest stringRequest=new StringRequest(Request.Method.GET, HttpUrl.PATH_FRAGMENT_TITLE+url,
                        new Response.Listener<String>() {
                            public void onResponse(String response) {
                                Log.e("baide",response);
                                try {
                                    JSONArray article = new JSONObject(response).getJSONArray("article");
                                    Gson gosn=new Gson();
                                    Type type=new TypeToken<List<TwoFragmentTitleModel>>(){}.getType();
                                    List<TwoFragmentTitleModel> data=gosn.fromJson(article.toString(),type);
                                    adapter.updateRes(data);
                                    editText.setText("");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FragmentTwoTitleActivity.this,"输入内容无效",Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(stringRequest);//添加到请求的队列
                break;

        }
    }
    //listView的点击事件
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,FragmentTwoSendActivity.class);
        intent.putExtra("id", adapter.getItem(position).getId());
        startActivity(intent);
    }
}
