package com.wzy.nofat.one_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wzy.nofat.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class TextVitamio extends AppCompatActivity {

    private VideoView mVideoView;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Vitamio.isInitialized(this);

        setContentView(R.layout.activity_text_vitamio);
        initView();
    }

    private void initView() {
        mVideoView = ((VideoView) findViewById(R.id.one_text_video_view));
        path="http://dlqncdn.miaopai.com/stream/MVaux41A4lkuWloBbGUGaQ__.mp4";
        if (path == ""){
            Toast.makeText(this, "地址无效", Toast.LENGTH_SHORT).show();
            return;
        }else {

            mVideoView.setVideoPath(path);
            mVideoView.setMediaController(new MediaController(this));

            mVideoView.requestFocus();
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setPlaybackSpeed(1.0f);
                }
            });
        }
    }
}
