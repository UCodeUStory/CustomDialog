package com.example.qiyue.customdialog.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.qiyue.customdialog.R;
import com.example.qiyue.customdialog.ui.CustomAlertDialog;

public class CustomAlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert_dialog);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomAlertDialog dialog = new CustomAlertDialog(CustomAlertDialogActivity.this);
                dialog.setMessage("急啊急啊纠结啊纠结啊急啊斤斤计较就");
                dialog.setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
