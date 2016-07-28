package com.wzy.nofat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.wzy.nofat.fragments.FragmentOne;
import com.wzy.nofat.fragments.FragmentThree;
import com.wzy.nofat.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private Fragment[] fragments;
    private RadioGroup main_radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        fragments = new Fragment[]{
                new FragmentOne(),
                new FragmentTwo(),
                new FragmentThree()
        };
        if (savedInstanceState != null) {
            for (int i = 0; i < fragments.length; i++) {
                fragments[i] = supportFragmentManager.findFragmentByTag("fragment" + i);

            }
        } else {
            for (int i = 0; i < fragments.length; i++) {
                transaction.add(R.id.main_fragment, fragments[i], "fragment" + i);
                transaction.hide(fragments[i]);
            }
            transaction.show(fragments[0]);
            transaction.commit();
        }
        initView();

    }

    private void initView() {
        main_radio_group = (RadioGroup) findViewById(R.id.main_radio_group);
        main_radio_group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int index = 0;
        switch (checkedId) {
            case R.id.main_radio_first:
                index = 0;
                break;
            case R.id.main_radio_second:
                index = 1;
                break;
            case R.id.main_radio_three:
                index = 2;
                break;


        }
        for (int i = 0; i < fragments.length; i++) {
            transaction.hide(fragments[i]);
            if (i == index) {
                transaction.show(fragments[i]);
            }
        }
        transaction.commit();

    }
}
