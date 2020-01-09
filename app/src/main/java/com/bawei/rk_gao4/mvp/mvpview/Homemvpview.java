package com.bawei.rk_gao4.mvp.mvpview;

import com.bawei.rk_gao4.base.IBaseView;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 19:15
 * @classname :Homemvpview
 */
public interface Homemvpview {
    interface Homeviewdata extends IBaseView {
        void showdata(String json);
        void faildata(String json);
        void show2data(String json);
        void show3data(String json);
        void show4data(String json);
    }

    interface  Homepresenter{
        void gethomedata(String path);
        void gethomedata2(String path);
        void gethomedata3(String path);
        void gethomedata4(String path);
    }
    interface  Homemodel{
        void gethomedata(String path, Mycallback mycallback);
         interface  Mycallback{
            void  Sucess(String json);
            void  fail(String mgs);
        }
    }

}
