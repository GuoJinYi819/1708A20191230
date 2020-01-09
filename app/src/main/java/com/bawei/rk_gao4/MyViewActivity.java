package com.bawei.rk_gao4;
import android.content.Intent;

import com.bawei.rk_gao4.base.BaseActivity;
import com.bawei.rk_gao4.mvp.Presenter.HomePresenter;
import com.bawei.rk_gao4.mvp.mvpview.Homemvpview;

public class MyViewActivity extends BaseActivity<HomePresenter> implements Homemvpview.Homeviewdata {

    private android.widget.TextView text;
    private Intent intent;
    private int id;

    @Override
    protected void initView() {
        text = findViewById(R.id.text);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        intent = getIntent();
        id = intent.getIntExtra("id",0);
        String path="http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?commodityId="+id;
        String json = "http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.gethomedata2(path);
    }

    @Override
    protected int initLayoutid() {
        return R.layout.activity_webview;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showdata(String json) {

    }

    @Override
    public void faildata(String json) {

    }

    @Override
    public void show2data(String json) {
        text.setText(json);
    }

    @Override
    public void show3data(String json) {

    }

    @Override
    public void show4data(String json) {

    }
}


