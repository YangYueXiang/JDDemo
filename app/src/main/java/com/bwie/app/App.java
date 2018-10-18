package com.bwie.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
