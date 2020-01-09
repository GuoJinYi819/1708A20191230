package com.bawei.rk_gao4.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public  abstract  class Basefragment<p extends  BasePresenter> extends Fragment {
 protected p presenter;
    protected  View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         int layoutid=   initLayoutid();
         view=  View.inflate(getActivity(),layoutid,null);
         return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       presenter = initPresenter();
        if (presenter != null) {
            presenter.attachview(this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract void  initView();
    protected abstract void  initListener();
    protected abstract void  initData();
    protected  abstract int  initLayoutid();
  protected abstract  p    initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachview();
        }
    }
}
