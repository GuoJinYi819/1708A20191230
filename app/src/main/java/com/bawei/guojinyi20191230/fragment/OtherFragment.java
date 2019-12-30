package com.bawei.guojinyi20191230.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.guojinyi20191230.R;
import com.bawei.guojinyi20191230.base.BaseFragment;
import com.bawei.guojinyi20191230.utils.NetUtil;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 11:46
 * @Description: 用途：完成特定功能
 */
public class OtherFragment extends BaseFragment {

    private TextView o;
    private LinearLayout linss;

    @Override
    protected int initLayoutId() {
        return R.layout.other_fragment;
    }

    @Override
    protected void initView() {
        o = view.findViewById(R.id.other_title);
        linss = view.findViewById(R.id.linsss);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
      //判断网络状态
        NetUtil instance = NetUtil.getInstance();
        boolean b = instance.dogetIntener();
        if(b){
            //有网
            Bundle arguments = getArguments();
            String title = arguments.getString("title");
            o.setText(title );
        }else{
            //没有网
            linss.setVisibility(View.VISIBLE);
        }
    }
}
