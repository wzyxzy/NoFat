package com.wzy.nofat.one_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wzy.nofat.R;
import com.wzy.nofat.one_model.Modle_TiaoZhuan;
import com.wzy.nofat.one_model.One_BigTiaoZhuan;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

public class TiaoZhanActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, PopupWindow.OnDismissListener {
    private static final String TAG = TiaoZhanActivity.class.getSimpleName();
    private int sid;
    private String URL;
    private List<Modle_TiaoZhuan> data;


    private WebView mWebView;
    private TextView name;
    private TextView zhishu;
    private RadioGroup mRadioGroup;
    //设定弹出
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao_zhan);
        initView();

    }



    private void initView() {
        //分享按钮
        mRadioGroup = ((RadioGroup) findViewById(R.id.one_tiaozhuan_radiogroup));
        mRadioGroup.setOnCheckedChangeListener(this);

        mWebView = ((WebView) findViewById(R.id.one_tiaochuan_webview));
        name = ((TextView) findViewById(R.id.one_tiaozhan_name));
        zhishu = ((TextView) findViewById(R.id.one_tiaozhuan_shoushenzhishu));

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        sid = bundle.getInt("key");
        Log.e(TAG,"sid111111111111111111111111111111111"+sid);
        URL = "http://bcp.525happy.com/base/stuff/";

       String url1= "?version=510&appkey=10001";
        Log.e(TAG, "url------------------" + URL);


    //加载条
//        mWebView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//            }
//        });

        RequestParams requestParams = new RequestParams(URL+sid+url1);
        Log.e(TAG,"requestParams"+requestParams);

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
               Gson gson = new Gson();
               One_BigTiaoZhuan tiaozhuan = gson.fromJson(result, One_BigTiaoZhuan.class);

               String desc = tiaozhuan.getStuff().getDesc();
                name.setText(tiaozhuan.getStuff().getName());
                zhishu.setText(tiaozhuan.getStuff().getEffect());

                //这是webView的设置选项 setting (设置)
                WebSettings settings = mWebView.getSettings();
                //设置支持javascript
                settings.setJavaScriptEnabled(true);
                //设置一个client
//                mWebView.setWebViewClient(new WebViewClient());
                Log.e(TAG, "DATA11111111111111111" + data);

                Log.e(TAG, "desc" + desc);
                mWebView.loadUrl(desc);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError");

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished");

            }
        });





    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){

            case R.id.one_tiaozhuan_fenxiang_rb:

                if (popupWindow == null) {
                    //点击完隐藏
//                    mRadioGroup.setVisibility(View.GONE);
//                    findViewById(R.id.one_tiaozhuan_fenxiang_rb).setVisibility(View.GONE);

                    popupWindow = new PopupWindow(this);
                    View layout = LayoutInflater.from(this).inflate(R.layout.one_popupwindow_items, null);
                    //指定popupwindow的高度
                    popupWindow.setContentView(layout);
                    popupWindow.setHeight(400);
                    popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
                    //设置popupwindow以外可点
                    popupWindow.setAnimationStyle(0);

                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setOnDismissListener(this);
                    //
                    popupWindow.showAsDropDown(group);
                }else {

                    if (popupWindow.isShowing()){
                        popupWindow.dismiss();
                    }else {
                        popupWindow.showAsDropDown(group);
                    }

                        mRadioGroup.setVisibility(View.VISIBLE);
                }


                break;


        }
    }

    @Override
    public void onDismiss() {

    }
}