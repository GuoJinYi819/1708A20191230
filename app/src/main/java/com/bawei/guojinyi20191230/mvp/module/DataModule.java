package com.bawei.guojinyi20191230.mvp.module;

import com.bawei.guojinyi20191230.mvp.contract.ContractClass;
import com.bawei.guojinyi20191230.utils.NetUtil;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 13:22
 * @Description: 用途：完成特定功能
 */
public class DataModule implements ContractClass.ConractModule {

    @Override
    public void getData(String path, final CallBack callBack) {
        NetUtil instance = NetUtil.getInstance();
        instance.dogetData(path, new NetUtil.DataCallBack() {
            @Override
            public void success(String json) {
                callBack.success(json);
            }

            @Override
            public void failed(String fai) {
                callBack.failed(fai);
            }
        });
    }
}
