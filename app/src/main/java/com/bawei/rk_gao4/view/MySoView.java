package com.bawei.rk_gao4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.rk_gao4.R;

/**
 * ClassName: RK_Gao4
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/1/10 18:02
 * @Description: 用途：完成特定功能
 */
public class MySoView extends LinearLayout {

    private Button sou;
    private EditText texts;
    private OnTextListener onTextListener;

    public void setOnTextListener(OnTextListener onTextListener) {
        this.onTextListener = onTextListener;
    }

    public MySoView(Context context) {
        super(context);
        init(context);
    }

    public MySoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MySoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context){
        View inflate = LayoutInflater.from(context).inflate(R.layout.mysoview_layout, this, true);
        sou = inflate.findViewById(R.id.btn_sou);
        texts = inflate.findViewById(R.id.et_text);
        //设置监听
        sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取值
                String s = texts.getText().toString();
                //log输出搜索结果
                onTextListener.onText(s);
            }
        });
    }
    public interface OnTextListener{
        void onText(String text);
    }
}
