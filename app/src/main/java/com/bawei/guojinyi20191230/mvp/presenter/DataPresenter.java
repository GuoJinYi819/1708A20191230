package com.bawei.guojinyi20191230.mvp.presenter;

import com.bawei.guojinyi20191230.mvp.module.DataModule;
import com.bawei.guojinyi20191230.mvp.view.DataView;
import com.bawei.guojinyi20191230.utils.NetUtil;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 13:23
 * @Description: 用途：完成特定功能
 */
public class DataPresenter {

    private DataModule dataModule;
    private DataView dataView;

    public void attachView(DataView dataView){
        this.dataView = dataView;
    }

    public DataPresenter() {
        dataModule = new DataModule();
    }

    public void getData(String path){

        dataModule.getData(path, new NetUtil.DataCallBack() {
            @Override
            public void success(String json) {
                dataView.success(json);
            }

            @Override
            public void failed(String fai) {
                dataView.failed(fai);
            }
        });
    }

}
