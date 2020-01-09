package com.bawei.rk_gao4.mvp.Presenter;

import com.bawei.rk_gao4.base.BasePresenter;
import com.bawei.rk_gao4.mvp.Model.HomeModel;
import com.bawei.rk_gao4.mvp.mvpview.Homemvpview;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 19:15
 * @classname :HomeModel
 */
public class HomePresenter extends BasePresenter<Homemvpview.Homeviewdata> implements Homemvpview.Homepresenter {

    private HomeModel homeModel;
    @Override
    public void initModel() {
        homeModel= new   HomeModel();
    }

    @Override
    public void gethomedata(String path) {
      homeModel.gethomedata(path, new Homemvpview.Homemodel.Mycallback() {
          @Override
          public void Sucess(String json) {
              iIBaseView.showdata(json);
          }

          @Override
          public void fail(String mgs) {
           iIBaseView.faildata(mgs);
          }
      });
    }

    @Override
    public void gethomedata2(String path) {
        homeModel.gethomedata(path, new Homemvpview.Homemodel.Mycallback() {
            @Override
            public void Sucess(String json) {
                iIBaseView.show2data(json);
            }

            @Override
            public void fail(String mgs) {
                iIBaseView.faildata(mgs);
            }
        });
    }

    @Override
    public void gethomedata3(String path) {
        homeModel.gethomedata(path, new Homemvpview.Homemodel.Mycallback() {
            @Override
            public void Sucess(String json) {
                iIBaseView.show3data(json);
            }

            @Override
            public void fail(String mgs) {
                iIBaseView.faildata(mgs);
            }
        });
    }

    @Override
    public void gethomedata4(String path) {
        homeModel.gethomedata(path, new Homemvpview.Homemodel.Mycallback() {
            @Override
            public void Sucess(String json) {
                iIBaseView.show4data(json);
            }

            @Override
            public void fail(String mgs) {
                iIBaseView.faildata(mgs);
            }
        });
    }
}
