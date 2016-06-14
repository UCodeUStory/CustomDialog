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

public class BottomPopWindowActivity extends AppCompatActivity {
    PopupWindow popupWindow;
    PopupWindow popBg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_pop_window);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(v);
            }
        });


    }

    private void showPopWindow(View v){
        LinearLayout layoutbackground = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.pop_bg,null);
        popBg = new PopupWindow(layoutbackground,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        popBg.showAtLocation(this.getWindow().getDecorView(),Gravity.BOTTOM,0,0);

        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.popwindow_bottom,null);
        layout.findViewById(R.id.zhifu_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBg.dismiss();
                popupWindow.dismiss();
            }
        });
        popupWindow = new PopupWindow(layout,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

      //  popupWindow.setFocusable(true);
       // popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.PopupAnimationBottom);
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);


    }
}
