package com.bawei.guojinyi20191230.utils;

import android.widget.ImageView;

import com.bawei.guojinyi20191230.App;
import com.bumptech.glide.Glide;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 13:36
 * @Description: 用途：完成特定功能
 */
public class ImageUtil {

    public void dogetimg(String path, ImageView imageView){
        Glide.with(App.context).load(path).into(imageView);

    }

}
