package com.example.qiyue.customdialog.ui;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.qiyue.customdialog.R;

/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/6/15 0015
 */
public class UToast {

    private static View mToastView;
    private static WindowManager mWdm;
    private static Handler mMHandler;

    public static void showToast(Context mContext){

        if (mToastView!=null){
            //mWdm.removeView(mToastView);
            return;
        }
        mToastView = LayoutInflater.from(mContext).inflate(R.layout.toast_layout,null);
        //mToastView = Toast.makeText(this, "toast", Toast.LENGTH_SHORT).getView();

        mWdm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mParams.windowAnimations = R.style.anim_view;//设置进入退出动画效果
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mParams.format = PixelFormat.RGBA_8888;
        mParams.y = -400;
        mWdm.addView(mToastView,mParams);
        mMHandler = new Handler(Looper.getMainLooper());
        mMHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWdm.removeView(mToastView);
                mToastView = null;
            }
        },3000);
    }

    public static void detachView(){
        if (mMHandler!=null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        if (mWdm!=null) {
            if (mToastView!=null) {
                mWdm.removeView(mToastView);
                mToastView = null;
            }
        }
    }


}
