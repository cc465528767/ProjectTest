package com.dreamkong.pracricewearher;

import android.app.Application;

import org.litepal.LitePalApplication;

/**
 * @author bsbj
 * @date 2018/3/11.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
