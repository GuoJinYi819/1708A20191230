package com.bawei.guojinyi20191230.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bawei.guojinyi20191230.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 11:28
 * @Description: 用途：完成特定功能
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例
    private static NetUtil instance;
    private NetUtil(){
    }
    public static NetUtil getInstance(){
        if (instance==null) {
            synchronized (NetUtil.class){
                if (instance==null) {
                    instance = new NetUtil();
                }
            }
        }
        return instance;
    }

    //获取数据
    @SuppressLint("StaticFieldLeak")
    public void dogetData(String path, final DataCallBack callBack){

        //获取数据
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(String... strings) {
                String str = strings[0];
                try {
                    URL url = new URL(str);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    //设置请求方式
                    httpURLConnection.setRequestMethod("GET");
                    //请求超时  读取超时
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);

                    int responseCode = httpURLConnection.getResponseCode();
                    if(responseCode==200){
                        //读取
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len=0;
                        byte[] bytes = new byte[1024];
                        StringBuffer buffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            buffer.append(new String(bytes,0,len));
                        }
                        //打印
                        String s = buffer.toString();
                        Log.i(TAG, "doInBackground: "+s);
                        //关流
                        inputStream.close();
                        return s;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //判空
                boolean empty = TextUtils.isEmpty(s);
                if(empty){
                    callBack.failed("请求失败");
                }else {
                    callBack.success(s);
                }
            }
        }.execute(path);

    }
    //网络状态
    public boolean dogetIntener(){
       ConnectivityManager connectivityManager = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }

    //接口回调
    public interface DataCallBack{
        void success(String json);
        void failed(String fai);
    }
}
