package com.bawei.rk_gao4.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.rk_gao4.R;
import com.bawei.rk_gao4.MyViewActivity;
import com.bawei.rk_gao4.bean.Goodbean;
import com.bawei.rk_gao4.net.ImgageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭金沂
 * Class :1708A
 * @description:
 * @date :2020/1/3 18:55
 * @classname :Myadaptertwo
 */
public class Myadaptertwo extends RecyclerView.Adapter<Myadaptertwo.ViewHolder>{
    private   List<Goodbean.ResultBean.MlssBean.CommodityListBeanXX> commodityList=new ArrayList<>();
    private Context context;

    public Myadaptertwo( List<Goodbean.ResultBean.MlssBean.CommodityListBeanXX> commodityList, Context context) {
        this.commodityList = commodityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.recylistview_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.name.setText(commodityList.get(i).getCommodityName());
        viewHolder.price.setText("$:"+commodityList.get(i).getPrice());
        ImgageUtil.getInstance().getphoto2(commodityList.get(i).getMasterPic(),viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MyViewActivity.class);
                intent.putExtra("id",commodityList.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
