package com.example.qiyue.customdialog.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.qiyue.customdialog.R;

public class PopWindowActivity extends AppCompatActivity {

    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwindow);
        TextView textView = (TextView)findViewById(R.id.tv_more);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(v);
            }
        });


    }

    private void showPopWindow(View v){
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.popwindow_layout,null);

        popupWindow = new PopupWindow(layout,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int statusBarHeight = getStatusBarHeight();
       // popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
      //  popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getHeight());
       // popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.TOP, 0, 0);
        popupWindow.showAtLocation(v, Gravity.TOP,0, statusBarHeight);

    }

    /**
     * 去除状态栏
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
