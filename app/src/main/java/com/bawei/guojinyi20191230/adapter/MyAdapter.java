package com.bawei.guojinyi20191230.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.guojinyi20191230.fragment.OtherFragment;
import com.bawei.guojinyi20191230.fragment.ShopingCartFragment;

import java.util.ArrayList;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 11:47
 * @Description: 用途：完成特定功能
 */
public class MyAdapter extends FragmentPagerAdapter {
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public MyAdapter(FragmentManager fm) {
        super(fm);
        //添加数据
        list.add("首页");
        list.add("分类");
        list.add("发现");
        list.add("购物车");
        list.add("我的");
        for (int i = 0; i < 5; i++) {
            if(i==3){
                ShopingCartFragment shopingCartFragment = new ShopingCartFragment();
                String s = list.get(3);
                Bundle bundle = new Bundle();
                bundle.putString("title",s);
                shopingCartFragment.setArguments(bundle);
                fragmentArrayList.add(shopingCartFragment);
            }else {
                OtherFragment otherFragment = new OtherFragment();
                String s = list.get(i);
                Bundle bundle = new Bundle();
                bundle.putString("title",s);
                otherFragment.setArguments(bundle);
                fragmentArrayList.add(otherFragment);
            }
        }

    }

    @Override
    public Fragment getItem(int i) {
        return fragmentArrayList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


}
