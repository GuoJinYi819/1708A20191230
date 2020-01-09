package com.bawei.rk_gao4.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bawei.rk_gao4.R;
import com.bawei.rk_gao4.adapter.Myadapterone;
import com.bawei.rk_gao4.adapters.Myadaptertwo;
import com.bawei.rk_gao4.adapters.Myadaptertwo1;
import com.bawei.rk_gao4.base.Basefragment;
import com.bawei.rk_gao4.bean.Goodbean;
import com.bawei.rk_gao4.bean.Xbannerbean;
import com.bawei.rk_gao4.mvp.Presenter.HomePresenter;
import com.bawei.rk_gao4.mvp.mvpview.Homemvpview;
import com.bawei.rk_gao4.net.ImgageUtil;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 17:33
 * @classname :Homefragment
 */
public class Homefragment extends Basefragment<HomePresenter> implements Homemvpview.Homeviewdata {
    private XBanner xbanner;
    private android.support.v7.widget.RecyclerView recycler_view1;
    private android.support.v7.widget.RecyclerView recycler_view2;
    private android.support.v7.widget.RecyclerView recycler_view3;
    private Myadapterone myadapterone;
    private Myadaptertwo myadaptertwo;
    private Myadaptertwo1 myadaptertwo1;


    @Override
    protected void initView() {

        xbanner = view.findViewById(R.id.xbanner);
        recycler_view1 = view.findViewById(R.id.recycler_view1);
        recycler_view2 = view.findViewById(R.id.recycler_view2);
        recycler_view3 = view.findViewById(R.id.recycler_view3);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        String xpath="http://172.17.8.100/small/commodity/v1/bannerShow";
      presenter.gethomedata(xpath);

        String path="http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.gethomedata2(path);

        String path2="http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.gethomedata3(path2);

        String path3="http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.gethomedata4(path3);
    }
    @Override
    protected int initLayoutid() {
        return R.layout.homefragment;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showdata(String json) {
        Gson gson=new Gson();
        Xbannerbean  xbannerbean = gson.fromJson(json, Xbannerbean.class);
        final List<Xbannerbean.ResultBean> result = xbannerbean.getResult();
        xbanner.setData(result,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImgageUtil.getInstance().getphoto(result.get(position).getImageUrl(), (ImageView) view);
            }
        });
    }

    @Override
    public void faildata(String json) {
    //请求失败
    }

    @Override
    public void show2data(String json) {
        Gson gson=new Gson();
        Goodbean goodbean = gson.fromJson(json, Goodbean.class);
        Goodbean.ResultBean  result = goodbean.getResult();
        Goodbean.ResultBean.RxxpBean rxxp = result.getRxxp();
        List<Goodbean.ResultBean.RxxpBean.CommodityListBean>  commodityList1 = rxxp.getCommodityList();
        myadapterone = new Myadapterone(commodityList1,getActivity());
        recycler_view1.setAdapter(myadapterone);
        recycler_view1.setLayoutManager(new GridLayoutManager(getActivity(),3));

    }

    @Override
    public void show3data(String json) {
        Gson gson=new Gson();
        Goodbean goodbean = gson.fromJson(json, Goodbean.class);
        Goodbean.ResultBean  result = goodbean.getResult();
        Goodbean.ResultBean.MlssBean  mlss = result.getMlss();
        List<Goodbean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlss.getCommodityList();
        myadaptertwo = new Myadaptertwo(commodityList, getActivity());
        recycler_view2.setAdapter(myadaptertwo);
        recycler_view2.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void show4data(String json) {
        Gson gson=new Gson();
        Goodbean goodbean = gson.fromJson(json, Goodbean.class);
        Goodbean.ResultBean  result = goodbean.getResult();
        Goodbean.ResultBean.PzshBean pzsh = result.getPzsh();
        List<Goodbean.ResultBean.PzshBean.CommodityListBeanX>    commodityList2 = pzsh.getCommodityList();

        myadaptertwo1 = new Myadaptertwo1(commodityList2,getActivity());
        recycler_view3.setAdapter(myadaptertwo1);
        recycler_view3.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
    }
}
