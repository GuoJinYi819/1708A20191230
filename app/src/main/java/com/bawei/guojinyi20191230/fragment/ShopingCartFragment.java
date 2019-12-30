package com.bawei.guojinyi20191230.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guojinyi20191230.MainActivity;
import com.bawei.guojinyi20191230.R;
import com.bawei.guojinyi20191230.adapter.GridAdapter;
import com.bawei.guojinyi20191230.base.BaseFragment;
import com.bawei.guojinyi20191230.bean.DataBean;
import com.bawei.guojinyi20191230.bean.ShopGridDataBean;
import com.bawei.guojinyi20191230.mvp.contract.ContractClass;
import com.bawei.guojinyi20191230.mvp.presenter.DataPresenter;
import com.bawei.guojinyi20191230.mvp.view.DataView;
import com.google.gson.Gson;

import java.util.List;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 11:45
 * @Description: 用途：完成特定功能
 */
public class ShopingCartFragment extends BaseFragment implements ContractClass.ConractView {

    private TextView t;
    private GridView grid_view;
    private Button go;

    @Override
    protected int initLayoutId() {
        return R.layout.shopping_fragment;
    }

    @Override
    protected void initView() {
        t = view.findViewById(R.id.t);
        grid_view = view.findViewById(R.id.grid_view);
        go = view.findViewById(R.id.go);
    }

    @Override
    protected void initListener() {
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.vp.setCurrentItem(0);
            }
        });
    }

    @Override
    protected void initData() {
        //获取数据
        Bundle arguments = getArguments();
        String title = arguments.getString("title");
        t.setText(title);

        //mvp模式 获取数据
        DataPresenter dataPresenter = new DataPresenter();

        String path = "http://blog.zhaoliang5156.cn/api/mall/mall.json";
        dataPresenter.attachView(path,this);
    }


    @Override
    public void viewPresenter(String josn) {
        //解析
        Gson gson = new Gson();
        DataBean dataBean = gson.fromJson(josn, DataBean.class);
        List<ShopGridDataBean> shopGridData = dataBean.getShopGridData();
        //设置适配器
        GridAdapter gridAdapter = new GridAdapter(shopGridData);
        grid_view.setAdapter(gridAdapter);
    }

    @Override
    public void viewFailed(String failed) {

    }
}
