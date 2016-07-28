package com.wzy.nofat.applications;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 16-4-11.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);

    }
}
