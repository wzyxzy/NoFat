package com.wzy.nofat.one_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.wzy.nofat.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class TiaoZhuan_WenZhang_Activity extends AppCompatActivity {

    private static final String TAG = TiaoZhuan_WenZhang_Activity.class.getSimpleName();
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao_zhuan__wen_zhang_);
        initView();

    }

    private void initView() {


        mWebView = ((WebView) findViewById(R.id.one_wenzhang_webview));
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String URLone = "http://bcp.525happy.com/baike/" ;
        int id =  bundle.getInt("key");
        Log.e(TAG,"id------------------------"+id);
        String URLtwo = "?version=510&appkey=10001";

        RequestParams requestParams = new RequestParams(URLone+id+URLtwo);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"onSuccess");
                try {
                    String shareLink = new JSONObject(result).getString("shareLink");

                    Log.e(TAG,"shareLink"+shareLink);
                    WebSettings settings = mWebView.getSettings();
                    settings.setJavaScriptEnabled(true);
                    mWebView.setWebChromeClient(new WebChromeClient());
                    mWebView.loadUrl(shareLink);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"onError");

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG,"onCancelled");

            }

            @Override
            public void onFinished() {
                Log.e(TAG,"onFinished");

            }
        });
    }
}
