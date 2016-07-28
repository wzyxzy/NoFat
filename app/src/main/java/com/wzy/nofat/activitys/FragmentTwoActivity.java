package com.wzy.nofat.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.adapters.FragmentTwoData;
import com.wzy.nofat.model.TwoFragmentData;
import com.wzy.nofat.model.TwoFragmentModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private ListView listView;
    private FragmentTwoData adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two);
        initView();
    }

    private void initView() {
        List<TwoFragmentData> list=new ArrayList<>();
        listView = ((ListView) findViewById(R.id.activity_fragment_two_listView));
        iv = ((ImageView) findViewById(R.id.activity_fragment_two_image));
        //取数据
        String url=getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
        String desc=getIntent().getStringExtra("desc");
        //添加数据
        TwoFragmentData model=new TwoFragmentData();
        model.setContent(url);
        model.setTitle(title);
        model.setDesc(desc);
        list.add(model);
        //绑定适配器
        adapter=new FragmentTwoData(list,this,R.layout.activity_fragment_two_data);
        listView.setAdapter(adapter);
        //点击事件
        iv.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_fragment_two_image:
                finish();
                break;
        }
    }
}
