package com.bawei.guojinyi20191230.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guojinyi20191230.App;
import com.bawei.guojinyi20191230.R;
import com.bawei.guojinyi20191230.bean.ShopGridDataBean;
import com.bawei.guojinyi20191230.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: 1708A20191230
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2019/12/30 13:28
 * @Description: 用途：完成特定功能
 */
public class GridAdapter extends BaseAdapter {
    private List<ShopGridDataBean> shopGridData = new ArrayList<>();

    public GridAdapter(List<ShopGridDataBean> shopGridData) {
        this.shopGridData.addAll(shopGridData);
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView= View.inflate(App.context, R.layout.grid_layout,null);
            holder.title = convertView.findViewById(R.id.ttt);
            holder.price = convertView.findViewById(R.id.price_1);
            holder.imageurl = convertView.findViewById(R.id.imageurl);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ShopGridDataBean shopGridDataBean = shopGridData.get(position);
        String title = shopGridDataBean.getTitle();
        holder.title.setText(title);
        String price = shopGridDataBean.getPrice();
        holder.price.setText(price);
        String imageurl = shopGridDataBean.getImageurl();
        //获取图片
        new ImageUtil().dogetimg(imageurl,holder.imageurl);
        return convertView;
    }
    class ViewHolder{
        private TextView title,price;
        private ImageView imageurl;
    }
}
