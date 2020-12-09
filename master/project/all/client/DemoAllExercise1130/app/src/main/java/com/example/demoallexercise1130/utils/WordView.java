package com.example.demoallexercise1130.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordView extends androidx.appcompat.widget.AppCompatTextView {
    private List mWordsList = new ArrayList();
    private Paint mLoseFocusPaint;
    private Paint mOnFocusePaint;
    private float mX = 0;
    private float mMiddleY = 0;
    private float mY = 0;
    private static final int DY = 50;
    private int mIndex = 0;

    public WordView(Context context) throws IOException {
        super(context);
        init();
    }

    public WordView(Context context, AttributeSet attrs) throws IOException {
        super(context, attrs);
        init();
    }

    public WordView(Context context, AttributeSet attrs, int defStyle) throws IOException {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("mindex", "onDraw: "+mIndex);
        //背景色
//        canvas.drawColor(Color.BLACK);
        if (mWordsList.size()!=0){
            //画笔
            Paint p = mLoseFocusPaint;
            p.setTextAlign(Paint.Align.CENTER);
            Paint p2 = mOnFocusePaint;
            p2.setTextAlign(Paint.Align.CENTER);
            canvas.drawText((String) mWordsList.get(mIndex), mX, mMiddleY, p2);
            int alphaValue = 25;
            float tempY = mMiddleY;
            for (int i = mIndex - 1; i >= 0; i--) {
                tempY -= DY;
                if (tempY < 0) {
                    break;
                }
                p.setColor(Color.argb(255 - alphaValue, 0, 0, 0));
                canvas.drawText((String) mWordsList.get(i), mX, tempY, p);
//            canvas.drawText("123\n456", mX, tempY, p);
                alphaValue += 25;
            }
            alphaValue = 25;
            tempY = mMiddleY;
            for (int i = mIndex + 1, len = mWordsList.size(); i < len; i++) {
                tempY += DY;
                if (tempY > mY) {
                    break;
                }
                p.setColor(Color.argb(255 - alphaValue, 100, 100, 100));
                canvas.drawText((String) mWordsList.get(i), mX, tempY, p);
                alphaValue += 25;
            }
            mIndex++;
        }


    }

    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        super.onSizeChanged(w, h, ow, oh);
        mX = w * 0.5f;
        mY = h;
        mMiddleY = h * 0.3f;
    }

//    @SuppressLint("SdCardPath")
    private void init() throws IOException {
        setFocusable(true);
        LrcHandle lrcHandler = new LrcHandle();

//        lrcHandler.readLRC("/sdcard/test.txt");
        lrcHandler.readLRC(getContext().getFilesDir()+"/test.lrc");
        mWordsList = lrcHandler.getmWords();
        //白色画笔表示未播放的
        mLoseFocusPaint = new Paint();
        mLoseFocusPaint.setAntiAlias(true);
        mLoseFocusPaint.setTextSize(40);
        mLoseFocusPaint.setColor(Color.BLACK);
        mLoseFocusPaint.setTypeface(Typeface.SERIF);

        // 黄色画笔表示正在播放的歌词
        mOnFocusePaint = new Paint();
        mOnFocusePaint.setAntiAlias(true);
        mOnFocusePaint.setColor(Color.BLUE);
        mOnFocusePaint.setTextSize(60);
        mOnFocusePaint.setTypeface(Typeface.SANS_SERIF);
    }
}