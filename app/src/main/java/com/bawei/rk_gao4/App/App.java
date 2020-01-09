package com.bawei.rk_gao4.App;

import android.app.Application;
import android.content.Context;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 16:54
 * @classname :App
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
