package com.wzy.nofat.adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wzy.nofat.R;

public class FragmentSendActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_send);
        findViewById(R.id.fragment_two_return_iv).setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v.getId()==R.id.fragment_two_return_iv){
            finish();
        }
    }
}
