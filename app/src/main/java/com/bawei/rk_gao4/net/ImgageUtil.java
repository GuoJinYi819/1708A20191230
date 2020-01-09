package com.bawei.rk_gao4.net;

import android.net.NetworkInfo;
import android.widget.ImageView;

import com.bawei.rk_gao4.App.App;
import com.bawei.rk_gao4.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

/**
 * @author 吴健
 * Class :1708A
 * @description:
 * @date :2020/1/3 18:59
 * @classname :ImgageUtil
 */
public class ImgageUtil {


    public  static ImgageUtil instance;


    private ImgageUtil() {
    }

    public static ImgageUtil getInstance() {
        if (instance ==null) {
            synchronized (ImgageUtil.class){
                if (instance==null) {
                    instance=new ImgageUtil();
                }
            }
        }
        return instance;
    }

    public  void getphoto(String path, ImageView imageView){
        Glide.with(App.context).load(path).priority(Priority.IMMEDIATE).error(R.mipmap.a1).fallback(R.mipmap.jjy).into(imageView);
    }
    public  void getphoto1(String path, ImageView imageView){
        Glide.with(App.context).load(path).priority(Priority.HIGH).error(R.mipmap.a1).fallback(R.mipmap.jjy).into(imageView);
    }
    public  void getphoto2(String path, ImageView imageView){
        Glide.with(App.context).load(path).priority(Priority.NORMAL).error(R.mipmap.a1).fallback(R.mipmap.jjy).into(imageView);
    }
    public  void getphoto3(String path, ImageView imageView){
        Glide.with(App.context).load(path).priority(Priority.LOW).error(R.mipmap.a1).fallback(R.mipmap.jjy).into(imageView);
    }
}
