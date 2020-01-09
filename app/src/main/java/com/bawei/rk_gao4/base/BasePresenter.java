package com.bawei.rk_gao4.base;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 19:11
 * @classname :BasePresenter
 */
public  abstract  class BasePresenter<view> {

    public BasePresenter() {
       initModel();
    }

    public view iIBaseView;

    public  void  attachview(view iIBaseView){
        this.iIBaseView=iIBaseView;
    }

    public  void detachview(){

        if (iIBaseView != null) {
            iIBaseView=null;
        }

    }
    public abstract void  initModel();
}
