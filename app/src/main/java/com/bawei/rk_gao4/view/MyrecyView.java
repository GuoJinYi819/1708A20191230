package com.bawei.rk_gao4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.rk_gao4.R;

/**
 * ClassName: RK_Gao4
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/1/8 18:10
 * @Description: 用途：完成特定功能
 */
public class MyrecyView extends View {

    private Paint paint;
    private  int color;
    public MyrecyView(Context context) {
        super(context);
        init();
    }

    public MyrecyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initAtrtrs(context,attrs);
    }

    public MyrecyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAtrtrs(context,attrs);
    }

    //获取自定义属性集
    private void initAtrtrs(Context context,AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyrecyView);
        color = typedArray.getColor(R.styleable.MyrecyView__colors, Color.parseColor("#FF0000"));
    }
    //设置画笔
    private  void init(){
        paint = new Paint();
        //设置画笔
        paint.setTextSize(10);
        //设置画笔粗度
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制坐标系X轴Y轴
        canvas.drawLine(50,0,50,400,paint);
        canvas.drawLine(45,400,500,400,paint);
        //绘制柱状图的柱子
        int left = 0;
        int top = 0;
        int right=0;
        int bottom=0;
        //间距
        int spare = 20;
        paint.setColor(color);
        canvas.drawRect(80,200,100,400,paint);
        canvas.drawRect(140,250,120,400,paint);
        canvas.drawRect(160,300,180,400,paint);

        canvas.drawRect(200,150,220,400,paint);
        canvas.drawRect(240,50,260,400,paint);
        canvas.drawRect(280,100,280,400,paint);
    }
}
