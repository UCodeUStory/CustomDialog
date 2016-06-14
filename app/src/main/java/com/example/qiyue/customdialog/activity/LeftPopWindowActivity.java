package com.example.qiyue.customdialog.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.qiyue.customdialog.R;

public class LeftPopWindowActivity extends AppCompatActivity {

    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_pop_window);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(v);
            }
        });
    }

    private void showPopWindow(View v){
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.leftpopwindow,null);

        popupWindow = new PopupWindow(layout,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.PopupAnimationLeft);
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int statusBarHeight = getStatusBarHeight();

        popupWindow.showAtLocation(v, Gravity.LEFT,0, 0);

    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
