package com.bawei.rk_gao4.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageView;

import com.bawei.rk_gao4.App.App;
import com.bumptech.glide.Glide;

/**
 * @author 吴健
 * Class :1708A
 * @description:
 * @date :2020/1/3 19:02
 * @classname :CacheUtil
 */
public class CacheUtil {

    public  static CacheUtil instance;
    private String string;


    private CacheUtil() {
    }

    private  final  static String  SP_NAME="sp_name";
    public static CacheUtil getInstance() {
        if (instance ==null) {
            synchronized (CacheUtil.class){
                if (instance==null) {
                    instance=new CacheUtil();
                }
            }
        }
        return instance;
    }

    public  void savedata(String url,String json){
        SharedPreferences sharedPreferences= App.context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=      sharedPreferences.edit();
        editor.putString(url,json);
        editor.commit();
    }
    public  String getdata(String url){
        SharedPreferences sharedPreferences2=App.context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        string = sharedPreferences2.getString(url, "");
        return string;
    }
}
