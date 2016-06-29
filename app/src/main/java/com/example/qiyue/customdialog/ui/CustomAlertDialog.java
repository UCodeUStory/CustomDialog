package com.example.qiyue.customdialog.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qiyue.customdialog.R;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class CustomAlertDialog{

    Context context;
    android.app.AlertDialog alertDialog;
    TextView titleView;
    TextView messageView;
    LinearLayout buttonLayout;


    public CustomAlertDialog(Context context){
        this.context=context;
        alertDialog = new android.app.AlertDialog.Builder(context).create();
        alertDialog.show();
        //关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.alert_dialog);
        messageView = (TextView)window.findViewById(R.id.message);
        buttonLayout = (LinearLayout)window.findViewById(R.id.buttonLayout);
    }


    public void setTitle(int resId)
    {
        titleView.setText(resId);
    }
    public void setTitle(String title) {
        titleView.setText(title);
    }
    public void setMessage(int resId) {
        messageView.setText(resId);
    }
    public void setMessage(String message)
    {
        messageView.setText(message);
    }

    /**
     * 设置按钮
     * @param text
     * @param listener
     */
    public void setPositiveButton(String text,final View.OnClickListener listener)
    {
        Button button=new Button(context);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
       // button.setBackgroundResource(R.drawable.alertdialog_button);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(listener);
        buttonLayout.addView(button);
    } 	/**
     * 设置按钮
     * @param text
     * @param listener
     */
    public void setNegativeButton(String text,final View.OnClickListener listener)
    {
        Button button=new Button(context);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
      //  button.setBackgroundResource(R.drawable.alertdialog_button);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(listener);
        if(buttonLayout.getChildCount()>0)
        {
            params.setMargins(20, 0, 0, 0);
            button.setLayoutParams(params);
            buttonLayout.addView(button, 1);
        }else{
            button.setLayoutParams(params);
            buttonLayout.addView(button);
        } 	}
    /**
     * 关闭对话框
     */
    public void dismiss() {
        alertDialog.dismiss();
    }
}