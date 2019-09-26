package com.privatee.wjtbaseapp.A_tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class ScrollTextSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private final static String TAG = "surfaceview";

    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Paint paint;
    private Thread thread;
    private boolean isShowing;

    //显示区域的宽度
    private int showAreaWidth;
    //显示区域的高度
    private int showAreaHeight;
    //滚动字幕文本内容
    private String textContent;
    //滚动字幕分割成多行文本的List
    private ArrayList<String> textContentList;
    //字体的大小
    private int textSize;
    //字体的颜色
    private int textColor;
    //滚动字幕的显示字体
    private Typeface textFont;
    //滚动的速度（滚动刷新的周期，单位：ms）
    private int scrollSpeed;
    //每次滚动的位移（单位：像素）
    private final int scrollStep = 1;

    //单行文本的高度
    private float singleLineHeightF;
    //若在给定宽度的区域内容，显示全部文本所需要的高度
    private float textTotalHeightF;
    //文本显示的偏移（单行文本的Top位置和显示的baseline的偏差）
    private float drawTextDeviationF;
    //滚动时实际显示文本内容的最高位置
    private float textTopPostionF;
    //滚动时当前显示文本的位置
    private float textTopCurPostionF;

    //整型的参数（对上面的参数向上取整），单位为像素：
    //单行文本的高度
    private int singleLineHeight;
    //若在给定宽度的区域内容，显示全部文本所需要的高度
    private int textTotalHeight;
    //文本显示的偏移（单行文本的Top位置和显示的baseline的偏差）
    private int drawTextDeviation;
    //滚动时实际显示文本内容的最高位置
    private int textTopPostion;
    //滚动时当前显示文本的位置
    private int textTopCurPostion;

    //是否请求控制线程退出
    private boolean reqCtrlThdQuit;

    public void displayParametersInit(String content, int size, int color, Typeface font, int speed) throws Exception {
        if (content == null || "".equals(content) || size <= 0 || font == null || speed <= 0) {
            throw new Exception("Invalid Parameters!");
        }
        //防止后面出现的不识别的内容
        this.textContent = content.trim();
        this.textSize = size;
        this.textColor = color;
        this.textFont = font;
        this.scrollSpeed = speed;
    }

    public void updateContent(String content) {
        if (content != null && !"".equals(content)) {
            textContent = content;
        }
    }

    public void show() {
        post(new Runnable() {
            @Override
            public void run() {
                //设定绘制参数
                paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextSize(textSize);
                paint.setTypeface(textFont);
                paint.setColor(textColor);

                //测量显示区域大小
                showAreaWidth = ScrollTextSurfaceView.this.getMeasuredWidth();
                showAreaHeight = ScrollTextSurfaceView.this.getMeasuredHeight();
                Log.i(TAG, "showAreaWidth: " + showAreaWidth);
                Log.i(TAG, "showAreaHeight: " + showAreaHeight);
                //拆分文本
                textContentList = breakTextToList(textContent, showAreaWidth, textSize, textFont);
                float[] top = new float[1];
                float[] ascent = new float[1];
                float[] leading = new float[1];
                float[] descent = new float[1];
                float[] bottom = new float[1];
                //获取文本显示参数
                getMetricsParameters(textContent, textSize, textFont, top, ascent, descent, bottom, leading);

                //精确的行高度和文本区域总高度
                singleLineHeightF = bottom[0] - top[0];
                Log.i(TAG, "singleLineHeightF: " + singleLineHeightF);
                singleLineHeight = (int)Math.ceil(singleLineHeightF);
                Log.i(TAG, "singleLineHeight: " + singleLineHeight);
                textTotalHeightF = textContentList.size() * singleLineHeightF;
                Log.i(TAG, "textTotalHeightF: " + textTotalHeightF);
                textTotalHeight = textContentList.size() * singleLineHeight;
                Log.i(TAG, "singleLineHeight: " + singleLineHeight);
                //绘制文本时的偏移（文本区域的top和绘制文本的baseline的距离）
                drawTextDeviationF = -top[0];
                Log.i(TAG, "drawTextDeviationF: " + drawTextDeviationF);
                drawTextDeviation = (int) Math.ceil(drawTextDeviationF);
                Log.i(TAG, "drawTextDeviation: " + drawTextDeviation);
//                //该方法不太准确，且导致行间距太小
//                singleLineHeight = getSingleLineTextHeight(textContent, textSize, textFont);
//                Log.i(TAG, "singleLineHeight: " + singleLineHeight);
//                textTotalHeight = textContentList.size() * singleLineHeight;
//                Log.i(TAG, "textTotalHeight: " + textTotalHeight);
                //启动绘制线程
                if (thread == null) {
                    reqCtrlThdQuit = false;
                    thread = new Thread(ScrollTextSurfaceView.this);
                    thread.start();
                } else {
                    reqCtrlThdQuit = true;
                    thread.interrupt();
                    //延时启动新的控制线程，以确保之前的控制线程退出，防止出现争夺canvas的现象
                    ScrollTextSurfaceView.this.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            thread = new Thread(ScrollTextSurfaceView.this);
                            thread.start();
                        }
                    }, 500);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollTextSurfaceView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollTextSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollTextSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollTextSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView(){

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setZOrderOnTop(true);
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        //surfaceHolder.setFormat(PixelFormat.TRANSPARENT);
        //setBackgroundColor(Color.parseColor("#00E7E7E7"));
        //getBackground().setAlpha(0);
//        setFocusable(true);
//        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
//        thread = new Thread(this);
        reqCtrlThdQuit = false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        isShowing = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        isShowing = false;
        if (thread != null) {
            reqCtrlThdQuit = true;
            thread.interrupt();
        }
    }

    @Override
    public void run() {
        Log.d(TAG, "run");

        if (isShowing) {
            //新版本采用更精确的float定位
            if (showAreaHeight >= textTotalHeightF) {
                //不需要滚动显示
                Log.i(TAG, "no scroll");
                try {
                    canvas = surfaceHolder.lockCanvas(new Rect());
                    //Log.d(TAG, "lock canvas");
                    if (canvas != null) {
                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                        float startY = (showAreaHeight - textTotalHeightF) / 2 + drawTextDeviationF;
                        float curY = startY;
                        for (int i = 0; i < textContentList.size(); i++) {
                            canvas.drawText(textContentList.get(i), 0, curY, paint);
                            curY += singleLineHeightF;
                        }
                    }
                } catch (Exception e) {
                    if (reqCtrlThdQuit) {
                        reqCtrlThdQuit = false;
                        Log.d(TAG, "View control thread exit!");
                    } else {
                        Log.e(TAG, "draw Text(no scroll) error!");
                        e.printStackTrace();
                    }
                } finally {
                    if (canvas != null) {
                        //Log.d(TAG, "unlock canvas");
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            } else {
                //需要滚动显示
//                Log.i(TAG, "scroll");
//                textTopPostionF = -(textTotalHeightF - drawTextDeviationF);
//                textTopCurPostionF = drawTextDeviationF;
//                while (isShowing) {
//                    long now = System.currentTimeMillis();
//                    try {
//                        canvas = surfaceHolder.lockCanvas();
//                        //Log.d(TAG, "lock canvas");
//                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//                        for (int i = 0; i < textContentList.size(); i++) {
//                            canvas.drawText(textContentList.get(i), 0, textTopCurPostionF + i * singleLineHeightF, paint);
//                        }
//                        for (int i = 0; i < textContentList.size(); i++) {
//                            canvas.drawText(textContentList.get(i), 0, textTotalHeightF + textTopCurPostionF + i * singleLineHeightF, paint);
//                        }
//                        if (textTopCurPostionF > textTopPostionF) {
//                            textTopCurPostionF -= scrollStep;
//                        } else {
//                            textTopCurPostionF = drawTextDeviationF;
//                        }
//                    } catch (Exception e) {
//                        if (reqCtrlThdQuit) {
//                            reqCtrlThdQuit = false;
//                            Log.d(TAG, "View control thread exit!");
//                            if (canvas != null) {
//                                surfaceHolder.unlockCanvasAndPost(canvas);
//                            }
//                            break;
//                        } else {
//                            Log.e(TAG, "draw Text(scroll) error!");
//                            e.printStackTrace();
//                        }
//                    } finally {
//                        if (canvas != null) {
//                            //Log.d(TAG, "unlock canvas");
//                            surfaceHolder.unlockCanvasAndPost(canvas);
//                        }
//                    }
//                    long next = scrollSpeed - (System.currentTimeMillis() - now);
//                    try {
//                        Thread.sleep(next);
//                    } catch (Exception e) {
//                        if (reqCtrlThdQuit) {
//                            reqCtrlThdQuit = false;
//                            Log.d(TAG, "View control thread exit!");
//                            break;
//                        } else {
//                            Log.e(TAG, "View control thread sleep error!");
//                            e.printStackTrace();
//                        }
//                    }
//                }

                //这里尝试使用整数，测试是否卡顿
                Log.i(TAG, "scroll");
                textTopPostion = -(textTotalHeight - drawTextDeviation);
                textTopCurPostion = drawTextDeviation;
                while (isShowing) {
                    long now = System.currentTimeMillis();
                    try {
                        canvas = surfaceHolder.lockCanvas();
                        //Log.d(TAG, "lock canvas");
                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                        for (int i = 0; i < textContentList.size(); i++) {
                            canvas.drawText(textContentList.get(i), 0, textTopCurPostion + i * singleLineHeight, paint);
                        }
                        for (int i = 0; i < textContentList.size(); i++) {
                            canvas.drawText(textContentList.get(i), 0, textTotalHeight + textTopCurPostion + i * singleLineHeight, paint);
                        }
                        if (textTopCurPostion > textTopPostion) {
                            textTopCurPostion -= scrollStep;
                        } else {
                            textTopCurPostion = drawTextDeviation;
                        }
                    } catch (Exception e) {
                        if (reqCtrlThdQuit) {
                            reqCtrlThdQuit = false;
                            Log.d(TAG, "View control thread exit!");
                            if (canvas != null) {
                                surfaceHolder.unlockCanvasAndPost(canvas);
                            }
                            break;
                        } else {
                            Log.e(TAG, "draw Text(scroll) error!");
                            e.printStackTrace();
                        }
                    } finally {
                        if (canvas != null) {
                            //Log.d(TAG, "unlock canvas");
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                    long next = scrollSpeed - (System.currentTimeMillis() - now);
                    if (next <= 0) {
                        continue;
                    }
                    try {
                        Thread.sleep(next);
                    } catch (Exception e) {
                        if (reqCtrlThdQuit) {
                            reqCtrlThdQuit = false;
                            Log.d(TAG, "View control thread exit!");
                            break;
                        } else {
                            Log.e(TAG, "View control thread sleep error!");
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    public static void getMetricsParameters(
            String content, int textSize, Typeface font,
            float[] top, float[] ascent, float[] descent, float[] bottom, float[] leading) {

        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setTypeface(font);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        top[0] = fontMetrics.top;
        ascent[0] = fontMetrics.ascent;
        descent[0] = fontMetrics.descent;
        bottom[0] = fontMetrics.bottom;
        leading[0] = fontMetrics.leading;
        Log.i(TAG, "top: " + top[0]);
        Log.i(TAG, "ascent: " + ascent[0]);
        Log.i(TAG, "descent: " + descent[0]);
        Log.i(TAG, "bottom: " + bottom[0]);
        Log.i(TAG, "leading: " + leading[0]);
        Log.i(TAG, "textHeight: " + (descent[0] - ascent[0]));
        Log.i(TAG, "singleTextAreaHeight: " + (bottom[0] - top[0]));
    }

    public static int getSingleLineTextHeight(String content, int textSize, Typeface font) {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setTypeface(font);
        paint.getTextBounds(content, 0, content.length(), rect);
        return rect.height();
    }

    public static ArrayList<String> breakTextToList(String content, int maxWidth, int textSize, Typeface font) {

        Log.d("breakTextToList", "content: " + content + " maxWidth: " + maxWidth + " textSize: " + textSize + " Typeface: " + font);
        if (content == null || "".equals(content) || maxWidth <= 0 || textSize <= 0 || font == null) {
            Log.d("breakTextToList", "Invalid parameters!");
            return null;
        }

        ArrayList<String> dstList = new ArrayList<String>();
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setTypeface(font);
        int totalLen = content.length();
        int breakedLen = 0;
        int ret;

        while (true) {
            ret = paint.breakText(content.substring(breakedLen), true, maxWidth, null);
            if (ret <= 0) {
                Log.d("breakTextToList", "ret error!");
                return null;
            }
            dstList.add(content.substring(breakedLen, breakedLen + ret));
            breakedLen += ret;
            if (breakedLen >= totalLen) {
                break;
            }
        }
        return dstList;
    }
}
