package com.bawei.guojinyi20191230;

import android.app.Application;
import android.content.Context;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 11:33
 * @Description: 用途：完成特定功能
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
