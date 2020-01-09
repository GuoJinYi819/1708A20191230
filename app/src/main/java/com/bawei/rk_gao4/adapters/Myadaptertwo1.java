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
 * @date :2020/1/6 18:47
 * @classname :Myadaptertwo1
 */
public class Myadaptertwo1 extends RecyclerView.Adapter<Myadaptertwo1.ViewHolder> {

    private List<Goodbean.ResultBean.PzshBean.CommodityListBeanX>    commodityList2 =new ArrayList<>();
    private Context context;

    public Myadaptertwo1(List<Goodbean.ResultBean.PzshBean.CommodityListBeanX>    commodityList2 , Context context) {
        this.commodityList2 = commodityList2;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.recylistview_item3,viewGroup,false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.name.setText(commodityList2.get(i).getCommodityName());
        viewHolder.price.setText("$:"+commodityList2.get(i).getPrice());
        ImgageUtil.getInstance().getphoto3(commodityList2.get(i).getMasterPic(),viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MyViewActivity.class);
                intent.putExtra("id",commodityList2.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList2.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView img,img2;
        TextView name,name2,price,price2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }

}
