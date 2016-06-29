package com.example.qiyue.customdialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qiyue.customdialog.activity.BottomPopWindowActivity;
import com.example.qiyue.customdialog.activity.CustomAlertDialogActivity;
import com.example.qiyue.customdialog.activity.LeftPopWindowActivity;
import com.example.qiyue.customdialog.activity.MenuDailogActivity;
import com.example.qiyue.customdialog.activity.TopPopWindowActivity;
import com.example.qiyue.customdialog.ui.CustomAlertDialog;
import com.example.qiyue.customdialog.ui.UToast;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    protected String []items = {"自定义弹出顶部popWindow","自定义Dialog实现弹出菜单","自定义左边弹出popWindow",
            "自定义底部弹出popWindow","完全自定义toast","自定义AlertDialog"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, TopPopWindowActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MenuDailogActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, LeftPopWindowActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, BottomPopWindowActivity.class));
                        break;
                    case 4:
                        UToast.showToast(MainActivity.this);
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,CustomAlertDialogActivity.class));
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        UToast.detachView();
       /* mMHandler.removeCallbacksAndMessages(null);
        mWdm.removeView(mToastView);*/
    }
}
