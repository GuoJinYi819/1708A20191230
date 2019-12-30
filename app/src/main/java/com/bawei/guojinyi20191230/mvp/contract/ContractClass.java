package com.bawei.guojinyi20191230.mvp.contract;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 15:02
 * @Description: 用途：契约类
 */
public interface ContractClass {

    //Presenter 接口
    public interface ContractPresenter{
        //设置View
        void attachView(String path,ContractClass.ConractView conractview);
        void presenterSuccess(String json);
        void presenterFailed(String failed);
    }
    //view  接口
    interface ConractView{
        void viewPresenter(String josn);
        void viewFailed(String failed);
    }
    //module 接口
    interface ConractModule{

        public void getData(String path,ConractModule.CallBack callBack);
        public interface CallBack{
            void success(String json);
            void failed(String failed);
        }
    }
}
