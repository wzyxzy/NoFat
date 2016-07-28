package com.wzy.nofat.one_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wzy.nofat.R;
import com.wzy.nofat.one_activity.TextVitamio;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_jianzhiqu extends Fragment implements View.OnClickListener {

    private View layout;
    private String path;
    public static final String TAG = Fragment_jianzhiqu.class.getSimpleName();


    private VideoView mVideoView;
    private ImageView mImageView;

    public Fragment_jianzhiqu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_fragment_jianzhiqu, container, false);
        initView();
        return layout;





    }

    private void initView() {
        mImageView = ((ImageView) layout.findViewById(R.id.one_shipin_image));
        mImageView.setOnClickListener(this);
//        Intent intent = new Intent(getActivity(),TextVitamio.class);
//        startActivity(intent);
//        Vitamio.isInitialized(getActivity());
//        mVideoView = ((VideoView) layout.findViewById(R.id.one_video_view));
//
//        path="http://dlqncdn.miaopai.com/stream/MVaux41A4lkuWloBbGUGaQ__.mp4";
//
//        if (path == ""){
//            Toast.makeText(getActivity(),"地址错误",Toast.LENGTH_SHORT).show();
//        }else {
//            mVideoView.setVideoPath(path);
//
//            mVideoView.setMediaController(new MediaController(getActivity()));
//
//            mVideoView.requestFocus();
//
//            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mp.setPlaybackSpeed(1.0f);
//                }
//            });
//        }

//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
//        mVideoView.setLayoutParams(layoutParams);
//        mVideoView.start();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one_shipin_image:
                Intent intent = new Intent(getActivity(),TextVitamio.class);
                startActivity(intent);
                break;
        }
    }
}
