package com.example.acer.bailiansong20180903.com.bwie.bailiansong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by acer on 2018/9/3.
 */

public class MyView extends View {
    private Paint paint;
    private Paint paint02;
    private int keDuY = 400;
    private int keDuX = 100;
    private int keDuTextY = 412;
    private int keDuTextX = 125;
    private String[] numY = {"0.00%","5.00%","10.00%","15.00%","20.00%","25.00%","30.00%","35.00%"};
    private String[] numX = {"管理成本","劳务成本","销售成本","资产盘亏"};
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setTextSize(25);
        paint02 = new Paint();
        paint02.setAntiAlias(true);
        paint02.setStrokeWidth(3);
        paint02.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画竖轴
        canvas.drawLine(100,50,100,410,paint);
        //画横轴
        canvas.drawLine(90,400,700,400,paint);
        //循环画竖轴刻度线
        for (int i = 0 ; i < 7 ; i++){
            keDuY-=50;
            canvas.drawLine(90,keDuY,100,keDuY,paint);
        }
        //循环画横轴刻度线
        for (int i = 0 ; i < 4 ; i++){
            keDuX+=150;
            canvas.drawLine(keDuX,400,keDuX,410,paint);
        }
        //循环画竖轴刻度值
        for (int i = 0 ; i < 8 ; i++){
            canvas.drawText(numY[i],0,keDuTextY,paint);
            keDuTextY-=50;
        }
        //循环画横轴刻度值
        for (int i = 0; i < 4 ; i++) {
            canvas.drawText(numX[i],keDuTextX,435,paint);
            keDuTextX+=150;
        }

        //画柱状图
        canvas.drawRect(125,125,225,400,paint02);
        canvas.drawRect(275,120,375,400,paint02);
        canvas.drawRect(425,187,525,400,paint02);
        canvas.drawRect(575,180,675,400,paint02);

        //写柱状图的数据
        canvas.drawText("27.64%",135,120,paint);
        canvas.drawText("28.17%",285,115,paint);
        canvas.drawText("21.48%",435,182,paint);
        canvas.drawText("22.70%",585,175,paint);
    }
}
