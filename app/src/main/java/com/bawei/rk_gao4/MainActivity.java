package com.bawei.rk_gao4;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.rk_gao4.adapter.MyRecyclerView;
import com.bawei.rk_gao4.adapter.Myadapterhome;
import com.bawei.rk_gao4.adapter.Myadapterone;
import com.bawei.rk_gao4.base.BaseActivity;
import com.bawei.rk_gao4.bean.Goodbean;
import com.bawei.rk_gao4.mvp.Presenter.HomePresenter;
import com.bawei.rk_gao4.mvp.mvpview.Homemvpview;
import com.bawei.rk_gao4.net.NetUtil;
import com.bawei.rk_gao4.view.MySoView;
import com.google.gson.Gson;

import java.net.URL;

public class MainActivity extends BaseActivity<HomePresenter> implements Homemvpview.Homeviewdata {
    private android.support.v4.view.ViewPager vphome;
    private android.support.design.widget.TabLayout tabhome;
    private Myadapterhome myadapterhome;
    private RelativeLayout recycler_Layout;
    private RelativeLayout recycler_Layout2;
    private RelativeLayout recycler_Layout3;
    private RecyclerView rl;

    @Override
    protected void initView() {

        vphome = findViewById(R.id.vphome);
        tabhome =  findViewById(R.id.tabhome);
        rl = findViewById(R.id.rl);
        MySoView so = findViewById(R.id.so);
        so.setOnTextListener(new MySoView.OnTextListener() {
            @Override
            public void onText(String text) {
                //请求接口
                String texts = Uri.encode(text, "utf_8");
                String path = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E6%89%8B%E6%9C%BA&page=1&count=5";
                //获取数据
                NetUtil.getInstance().getjson(path, new NetUtil.Mycallback() {
                    @Override
                    public void Sucess(String json) {
                        //解析
                        Gson gson = new Gson();
                       // Goodbean goodbean = gson.fromJson(json, Goodbean.class);
                        Goodbean.ResultBean result = null;
                        //创建适配器
                        MyRecyclerView myRecyclerView = new MyRecyclerView(result);
                        rl.setAdapter(myRecyclerView);
                    }

                    @Override
                    public void fail(String mgs) {

                    }
                });
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        myadapterhome = new Myadapterhome(getSupportFragmentManager());
        vphome.setAdapter(myadapterhome);
        tabhome.setupWithViewPager(vphome);
    }

    @Override
    protected int initLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    protected HomePresenter initPresenter() {
        return null;
    }

    @Override
    public void showdata(String json) {
        recycler_Layout = findViewById(R.id.relative_layout);
        recycler_Layout3 = findViewById(R.id.relative_layout3);
        recycler_Layout2 = findViewById(R.id.relative_layout2);
        //网格布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        //设置方向
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recycler_Layout.generateLayoutParams((AttributeSet) gridLayoutManager);
        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_Layout.generateLayoutParams((AttributeSet) gridLayoutManager);
        //瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycler_Layout.generateLayoutParams((AttributeSet) gridLayoutManager);
        //设置适配器
        Myadapterone myadapterone = new Myadapterone(null,null);


    }

    @Override
    public void faildata(String json) {

    }

    @Override
    public void show2data(String json) {

    }

    @Override
    public void show3data(String json) {

    }

    @Override
    public void show4data(String json) {

    }
}
