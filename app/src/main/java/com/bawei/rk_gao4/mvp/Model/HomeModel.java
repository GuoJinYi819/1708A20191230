package com.bawei.rk_gao4.mvp.Model;

import com.bawei.rk_gao4.mvp.mvpview.Homemvpview;
import com.bawei.rk_gao4.net.NetUtil;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 19:15
 * @classname :HomeModel
 */
public class HomeModel implements Homemvpview.Homemodel {
    @Override
    public void gethomedata(String path, final Homemvpview.Homemodel.Mycallback mycallback) {
        NetUtil.getInstance().getjson(path, new NetUtil.Mycallback() {
            @Override
            public void Sucess(String json) {
                mycallback.Sucess(json);
            }

            @Override
            public void fail(String mgs) {
                 mycallback.fail(mgs);
            }
        });
    }
}
