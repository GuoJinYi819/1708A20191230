package com.bawei.rk_gao4.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.rk_gao4.fragment.Homefragment;
import com.bawei.rk_gao4.fragment.fragmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 16:59
 * @classname :Myadapterhome
 */
public class Myadapterhome extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private  List<String>title =new ArrayList<>();
    public Myadapterhome(FragmentManager fm) {
        super(fm);
        for (int i = 0; i <5 ; i++) {
            if (i==0) {
                fragments.add(new Homefragment());
            }
            else {
                fragments.add(new fragmentOne());
            }
        }
        title.add("首页");
        title.add("分类");
        title.add("发现");
        title.add("购物车");
        title.add("我的");

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
