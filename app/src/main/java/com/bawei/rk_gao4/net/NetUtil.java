package com.bawei.rk_gao4.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.rk_gao4.App.App;

/**
 * @author 吴健
 * Class :1708A
 * @description:
 * @date :2020/1/3 18:51
 * @classname :NetUtil
 */
public class NetUtil {

    public  static NetUtil instance;
    private final RequestQueue requestQueue;
    private NetworkInfo networkInfo;
    private boolean available;
    private StringRequest request;
    private boolean netby;
    private String getdata;
    private boolean empty;

    private NetUtil() {
        requestQueue = Volley.newRequestQueue(App.context);
    }

    public static NetUtil getInstance() {
        if (instance ==null) {
            synchronized (NetUtil.class){
                if (instance==null) {
                    instance=new NetUtil();
                }
            }
        }
        return instance;
    }


    public  void  getjson(final String path, final Mycallback mycallback){

        netby = netby();
        if (!netby) {

            getdata = CacheUtil.getInstance().getdata(path);
            empty = TextUtils.isEmpty(getdata);
            if (!empty) {
                mycallback.Sucess(getdata);
            }
            else {
                mycallback.fail("请求失败");
            }
            return;
        }
        request = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallback.Sucess(response);
                Log.d("xxx", "onResponse: " + response);
                CacheUtil.getInstance().savedata(path, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallback.fail(error.getMessage());
            }
        });
        requestQueue.add(request);
    }
    public interface  Mycallback{
        void  Sucess(String json);
        void  fail(String mgs);
    }

    public boolean netby(){
   ConnectivityManager connectivityManager= (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            available = networkInfo.isAvailable();
            return available;
        }
        return false;
    }
}
