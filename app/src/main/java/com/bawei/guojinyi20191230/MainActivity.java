package com.bawei.guojinyi20191230;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.guojinyi20191230.adapter.MyAdapter;
import com.bawei.guojinyi20191230.base.BaseActivity;

public class MainActivity extends BaseActivity {

    public static ViewPager vp;
    private android.support.design.widget.TabLayout tl;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        vp = (ViewPager) findViewById(R.id.vp);
        tl = (TabLayout) findViewById(R.id.tl);
    }

    @Override
    protected void initListener() {
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vp.setCurrentItem(position);
                tab.setIcon(R.mipmap.show);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(R.mipmap.show1);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tl.setScrollPosition(i,0,true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @Override
    protected void initData() {
        //设置数据
        TabLayout.Tab tab = tl.newTab();
        tab.setText("首页");
        tab.setIcon(R.mipmap.show1);
        tl.addTab(tab);
        tab = tl.newTab();
        tab.setText("分类");
        tab.setIcon(R.mipmap.show1);
        tl.addTab(tab);
        tab = tl.newTab();
        tab.setText("发现");
        tab.setIcon(R.mipmap.show1);
        tl.addTab(tab);tab = tl.newTab();
        tab.setText("购物车");
        tab.setIcon(R.mipmap.show1);
        tl.addTab(tab);tab = tl.newTab();
        tab.setText("我的");
        tab.setIcon(R.mipmap.show1);
        tl.addTab(tab);

        //设置适配器
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdapter);
    }
}
