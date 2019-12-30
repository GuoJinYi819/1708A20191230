package com.bawei.guojinyi20191230.mvp.presenter;

import com.bawei.guojinyi20191230.mvp.contract.ContractClass;
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
public class DataPresenter implements ContractClass.ContractPresenter {
    private DataModule dataModule = new DataModule();

    @Override
    public void attachView(String path,final ContractClass.ConractView conractview) {
        ;dataModule.getData(path, new ContractClass.ConractModule.CallBack() {
            @Override
            public void success(String json) {
                conractview.viewPresenter(json);
            }

            @Override
            public void failed(String failed) {
                conractview.viewFailed(failed);
            }
        });
    }

    @Override
    public void presenterSuccess(String json) {

    }

    @Override
    public void presenterFailed(String failed) {

    }
}
