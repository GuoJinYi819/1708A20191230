package com.bawei.rk_gao4.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/2 10:04
 * @classname :BaseActivity
 */
public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {

    protected p presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
      int layoutid=  initLayoutid();
        setContentView(layoutid);
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachview(this);
        }
        initView();
        initListener();
        initData();
    }
    protected  abstract  void initView();
    protected  abstract  void initListener();
    protected  abstract  void initData();
    protected  abstract  int initLayoutid();
    protected abstract  p    initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachview();
        }
    }

}
