package com.privatee.wjtbaseapp.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/23 10:29.
 */
public class MyattributeView  extends View{
    private  int age;
    private  String name;
    private Bitmap bg;
    public MyattributeView(Context context) {
        super(context);
    }
    //两个参数的构造函数在布局中使用
    public MyattributeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    //获取属性的三种方式
    //1.用命名空间去获取 ： xmlns:wjtcustom="http://schemas.android.com/apk/res-auto"
//    String age=attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_age");
//    String name=attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_name");
//    String bg=attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_bg");
//    Log.i("GOGOGO","age==" + age + "name=" + name + "bg==" + bg);
    //2 for循环遍历
//        for(int i=0;i<attrs.getAttributeCount();i++){
//            Log.i("GOGOGO",attrs.getAttributeName(i)+"==="+attrs.getAttributeValue(i));
//        }


        // 3 使用系统工具获取
//        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyattributeView);
//        for(int i=0;i<typedArray.getIndexCount();i++){
//             int intex=typedArray.getIndex(i);
//             switch (intex){
//                 case R.styleable.MyattributeView_my_age:
//                     age=typedArray.getInt(intex,0);
//                     Log.i("GOGOGO", age+"" );
//                             break;
//                 case R.styleable.MyattributeView_my_name:
//                     name=typedArray.getString(intex);
//                     Log.i("GOGOGO",name);
//                             break;
//                 case R.styleable.MyattributeView_my_bg:
//                    Drawable drawable=typedArray.getDrawable(intex);
//                     BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
//                     bg=bitmapDrawable.getBitmap();
//                             break;
//             }
//        }
    }


    public MyattributeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//设置填充样式
//        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(2);//设置画笔宽度
//        canvas.drawText(name+"---"+age,50,50,paint);
//        canvas.drawBitmap(bg,50,50,paint);

//        float []pts={50,500,80,80,100,100,200,200,400,400};
        //offset：跳过的数据个数，这些数据将不参与绘制过程。
        //count：实际参与绘制的数据个数。
//        canvas.drawPoints(pts, 2, 8, paint);

        //  矩形 距离 左 上 右 下 的距离
//        RectF rect = new RectF(120, 10, 210, 100);
//        canvas.drawRect(rect, paint);//使用RectF构造
        //圆
//      canvas.drawCircle(500,600,500,paint);

        //弧形  矩形  弧开始的角度，以x轴正方向为0度，弧持续的角度 也就是弧的角度，是否有其他两边
//        RectF rect1 = new RectF(100, 10, 300, 100);
//        canvas.drawArc(rect1, 0, 40, true, paint);
//        RectF rect2 = new RectF(400, 10, 600, 100);
//        canvas.drawArc(rect2, 90, 40, true, paint);

        //canvas中绘制路径
//        Path path=new Path();
//        path.moveTo(10,10);//设立起点
//        path.lineTo(500,10);//第一条线的终点，也是第二条线的终点
//        path.lineTo(500,200);//第二条线的起点
//        path.lineTo(10,200);//第三条线
//        path.close();//如果没有连起来就闭环
//        canvas.drawPath(path, paint);


        //矩形路径
        //void addRect (float left, float top, float right, float bottom, Path.Direction dir)
        //void addRect (RectF rect, Path.Direction dir)
        //这里Path类创建矩形路径的参数与上篇canvas绘制矩形差不多，唯一不同的一点是增加了Path.Direction参数；
        //Path.Direction有两个值：
        //Path.Direction.CCW：是counter-clockwise缩写，指创建逆时针方向的矩形路径；
        //Path.Direction.CW：是clockwise的缩写，指创建顺时针方向的矩形路径；

        //先创建两个大小一样的路径
        //第一个逆向生成
//        Path CCWRectpath = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        CCWRectpath.addRect(rect1, Path.Direction.CCW);
//        //第二个顺向生成
//        Path CWRectpath = new Path();
//        RectF rect2 =  new RectF(290, 50, 480, 200);
//        CWRectpath.addRect(rect2, Path.Direction.CW);
//        canvas.drawPath(CCWRectpath,paint);
//        canvas.drawPath(CWRectpath,paint);
//
//        //依据路径写出文字
//        String text="风萧萧兮易水寒，壮士一去兮不复返";
//        paint.setColor(Color.GRAY);
//        paint.setTextSize(35);
//        canvas.drawTextOnPath(text,CCWRectpath,0,18,paint);
//        canvas.drawTextOnPath(text,CWRectpath,0,18,paint);




//        //圆形路径
//
//        Path path = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        path.addRoundRect(rect1, 10, 90 , Path.Direction.CCW);
//        canvas.drawPath(path,paint);

        //设置倾斜  文字，起点x轴坐标，y坐标
//        paint.setTextSize(50);
//        paint.setTextSkewX((float)-0.25);
//        canvas.drawText("这是我用心里面的血液外面的皮肤写的",10,200,paint);

        //设置每一个字体的位置
//        paint.setTextSize(50);
//        float []pos=new float[]{80,100,
//                80,200,
//                80,300,
//                80,400};
//        canvas.drawPosText("呀胡嘿啊",pos,paint);

//        Paint greenPaint=new Paint();
//        greenPaint.setColor(Color.GREEN);
//        greenPaint.setStyle(Paint.Style.FILL);
//        greenPaint.setStrokeWidth(3);
//        Rect rect=new Rect(200,50,400,220);
//        canvas.drawRect(rect, paint);
//        //平移 x轴 y轴
////        canvas.translate(100,100);
//        canvas.rotate(90);//旋转90度
//        canvas.drawRect(rect, greenPaint);

        //旋转
        //void rotate(float degrees)
        //void rotate (float degrees, float px, float py)
        //第一个构造函数直接输入旋转的度数，正数是顺时针旋转，负数指逆时针旋转，它的旋转中心点是原点（0，0）
        //第二个构造函数除了度数以外，还可以指定旋转的中心点坐标（px,py）

//        Rect rect1 = new Rect(10,10,200,100);
//        canvas.drawRect(rect1, greenPaint);
//        canvas.skew(1.732f,0);//X轴倾斜60度 就是tan60度，Y轴不变  扭曲
//        canvas.drawRect(rect1, paint);
        //裁剪
//        canvas.drawColor(Color.RED);
//        canvas.save();
//        canvas.clipRect(new Rect(100, 100, 200, 200));
//        canvas.drawColor(Color.GREEN);
//        //恢复整屏画布
//        canvas.restore();
//        canvas.drawColor(Color.BLUE);
//        canvas.clipRect(new Rect(100, 100, 800, 800));
//        canvas.drawColor(Color.GREEN);
//        canvas.save();
//        canvas.clipRect(new Rect(200, 200, 700, 700));
//        canvas.drawColor(Color.BLUE);
//        //保存画布大小为Rect(200, 200, 700, 700)
//        canvas.save();
//        canvas.clipRect(new Rect(200, 200, 600, 600));
//        canvas.drawColor(Color.BLACK);
//        //保存画布大小为Rect(200, 200, 700, 700)
//        canvas.save();
//        canvas.clipRect(new Rect(400, 400, 500, 500));
//        canvas.drawColor(Color.WHITE);
//        canvas.save();
//        canvas.restore();//会把顶层的画布状态取出来变成当前画布，在上面画，
//        canvas.drawColor(Color.YELLOW);

        //贝尔赛曲线
//        Path path=new Path();
//        path.moveTo(20,20);//起点
//        path.quadTo(200,200,300,300);
//        path.quadTo(500,500,500,610);
//        canvas.drawPath(path,paint);
    }

}
