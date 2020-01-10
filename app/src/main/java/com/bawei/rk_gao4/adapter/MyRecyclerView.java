package com.bawei.rk_gao4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.rk_gao4.App.App;
import com.bawei.rk_gao4.R;
import com.bawei.rk_gao4.bean.Goodbean;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ClassName: RK_Gao4
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/1/10 18:20
 * @Description: 用途：完成特定功能
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {
    private  Goodbean.ResultBean result = new Goodbean.ResultBean();
    private ArrayList<String> list = new ArrayList<>();

    public MyRecyclerView(Goodbean.ResultBean result) {
        list.add("手机");
        list.add("手机");
        list.add("手机");
        list.add("手机");
        list.add("手机");
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(App.context).inflate(R.layout.item_1, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String s = list.get(position);
        holder.textView.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.tt);
        }
    }
}
