package com.wzy.nofat.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.wzy.nofat.R;

public class GotoWebView extends AppCompatActivity {

    private WebView three_webview;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto_web_view);
        initData();
        initView();
    }

    private void initData() {
        Intent intent=getIntent();
        url=intent.getStringExtra("infoUrl");


    }

    private void initView() {
        three_webview = (WebView) findViewById(R.id.three_webview);
        three_webview=new WebView(this);
        three_webview.getSettings().setJavaScriptEnabled(true);
        three_webview.loadUrl(url);
        setContentView(three_webview);
    }
}
