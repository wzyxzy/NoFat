package com.wzy.nofat.activitys;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoJsonModel;

import java.util.ArrayList;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private VideoView videoView;
    private ArrayList<TwoJsonModel> data;
    private ListView listView;
    private DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Vitamio的第三方的依赖包
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_video_view);
        initView();
        initData();

    }
    //播放器
    private void initPlay(String url) {
        //初始化路径
        videoView.setVideoPath(url);
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // optional need Vitamio 4.0
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }
    //绑定适配器
    private void initData() {
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i <data.size() ; i++) {
            String title=data.get(i).getTitle();
            list.add(title);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }
    //初始化
    private void initView() {
        drawerLayout = ((DrawerLayout) findViewById(R.id.drawerLayout));
        videoView = ((VideoView) findViewById(R.id.activity_video_view));
        listView = ((ListView) findViewById(R.id.draw_list));
        listView.setOnItemClickListener(this);
        videoView.setMediaController(new MediaController(this));

        Bundle bundle=getIntent().getBundleExtra("bundle");

        data=bundle.getParcelableArrayList("data");
        String url=bundle.getString("url");
        initPlay(url);

    }
    //listView的点击事件
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url=data.get(position).getUrl();
        Log.e("baidu", url);
        initPlay(url);
        drawerLayout.closeDrawer(findViewById(R.id.activity_video_layout));
    }
}
