package com.bawei.rk_gao4.adapter;

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
 * @date :2020/1/3 19:35
 * @classname :Myadapterone
 */
public class Myadapterone extends RecyclerView.Adapter<Myadapterone.ViewHolder>{
 private    List<Goodbean.ResultBean.RxxpBean.CommodityListBean>  commodityList1=new ArrayList<>();
  private Context context;

    public Myadapterone( List<Goodbean.ResultBean.RxxpBean.CommodityListBean>  commodityList1, Context context) {
        this.commodityList1 = commodityList1;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

         View  view= LayoutInflater.from(context).inflate(R.layout.recylistview_item2,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
      viewHolder.name.setText(commodityList1.get(i).getCommodityName());
      viewHolder.price.setText("$:"+commodityList1.get(i).getPrice());
      ImgageUtil.getInstance().getphoto1(commodityList1.get(i).getMasterPic(),viewHolder.img);
      viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(context, MyViewActivity.class);
              intent.putExtra("id",commodityList1.get(i).getCommodityId());
              context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return commodityList1.size();
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
