package com.wzy.nofat.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wzy.nofat.R;

public class ChouJiangActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chou_jiang);
        initView();
    }

    private void initView() {
        findViewById(R.id.choujiang_return).setOnClickListener(this);
        findViewById(R.id.choujiang_text).setOnClickListener(this);
        //设置个数
        tv = ((TextView) findViewById(R.id.choujiao_copunt));
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.choujiang_return:
                finish();
                break;
            case R.id.choujiang_text://抽奖
                Intent intent=new Intent(this,FragmentTwo.class);
                startActivityForResult(intent,1);
                break;
        }
    }
}
