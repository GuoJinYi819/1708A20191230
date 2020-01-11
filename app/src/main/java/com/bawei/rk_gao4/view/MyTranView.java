package com.bawei.rk_gao4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ClassName: RK_Gao4
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/1/11 21:04
 * @Description: 用途：完成特定功能
 */
public class MyTranView extends View {

    private Paint paint;

    public MyTranView(Context context) {
        super(context);
        init();
    }

    public MyTranView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTranView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(10);
        paint.setColor(Color.RED);
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        //绘制自定义view
        canvas.drawRect(0,0,100,100,paint);
    }
}
