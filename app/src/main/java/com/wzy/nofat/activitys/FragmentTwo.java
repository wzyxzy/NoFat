package com.wzy.nofat.activitys;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.wzy.nofat.R;

public class FragmentTwo extends AppCompatActivity implements View.OnClickListener ,Handler.Callback{
    //帧动画
    private AnimationDrawable ad;
    private ImageView iv;
    private Handler mHandler;
    private int position;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two2);
        initView();
    }

    private void initView() {
        findViewById(R.id.activity_framment_return).setOnClickListener(this);
        findViewById(R.id.activity_framment_tv).setOnClickListener(this);
        iv = ((ImageView) findViewById(R.id.activity_framment_image));
        //设置背景资源，这个R.drawable.loading布局在res/drawable/下面了里面写了一个布局名字叫loading
        //,设置资源，
        iv.setBackgroundResource(R.drawable.loading);
        //将动画资源取出来
        ad= (AnimationDrawable) iv.getBackground();
        //动画开始跑起来
        iv.setVisibility(View.INVISIBLE);
        mHandler=new Handler(this);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_framment_return:
                finish();
                break;
            case R.id.activity_framment_tv:
                iv.setVisibility(View.INVISIBLE);
                position=0;
                Message msg=Message.obtain();
                msg.what=1;
                if(mHandler!=null){
                    Log.e("baidu","8888");
                    mHandler.sendMessage(msg);
                }

                break;
        }
    }

    public boolean handleMessage(Message msg) {
        position++;
        switch (msg.what){
            case 1:
                if(position<20){
                    iv.setBackgroundResource(R.drawable.loading);
                    //将动画资源取出来
                    ad= (AnimationDrawable) iv.getBackground();
                    iv.setVisibility(View.VISIBLE);
                    ad.start();
                    Log.e("baidu","11111");
                    Message msg1=Message.obtain();
                    msg1.what=1;
                    try {
                       Thread.sleep(100);
                        mHandler.sendMessage(msg1);
                        Log.e("baidu", "22222");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    ad.stop();
                    iv.setImageResource(R.mipmap.lottery_thanks_small);
                    Log.e("baidu", "33333");
                }
        }
        return false;
    }
}
/*
          //时间选择Dialog
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        Toast.makeText(MainActivity.this,
                                "year:" + year + " monthOfYear:" + (monthOfYear + 1) + " dayOfMonth:" + dayOfMonth, Toast.LENGTH_SHORT).show();
                        timeEdit.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
                    } //默认日期
                }, y, m, d);
                dialog.show();
 */