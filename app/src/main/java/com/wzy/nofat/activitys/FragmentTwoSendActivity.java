package com.wzy.nofat.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;

import com.wzy.nofat.R;

import com.wzy.nofat.model.TwoFragmentTitleModel;
import com.wzy.nofat.url.HttpUrl;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwoSendActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two_send);
        initView();
    }

    private void initView() {
        iv = ((ImageView) findViewById(R.id.activity_fragment_two_send_image));
        iv.setOnClickListener(this);
        webView = (WebView) findViewById(R.id.activity_fragment_two_send_webView);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id", 0);

        webView.loadUrl(HttpUrl.PATH_FRAGMENT_TIAO+id);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_fragment_two_send_image:
                finish();
                break;
        }
    }
}
