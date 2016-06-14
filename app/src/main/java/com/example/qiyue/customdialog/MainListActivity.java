package com.example.qiyue.customdialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiyue.customdialog.activity.BottomPopWindowActivity;
import com.example.qiyue.customdialog.activity.LeftPopWindowActivity;
import com.example.qiyue.customdialog.activity.MenuDailogActivity;
import com.example.qiyue.customdialog.activity.PopWindowActivity;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity implements OnClickListener{
    WindowManager mWdm;
    private WindowManager.LayoutParams mParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        ViewBuilder viewBuilder = new ViewBuilder(this);
        viewBuilder.$(R.id.full_screen_btn)
                .$(R.id.two_btn)
                .$(R.id.three_btn)
                .$(R.id.four_btn)
                .$(R.id.five_btn)
                .setOnClickListener(this);
        TextView textView = new TextView(this);
        textView.setText("哈哈");
        mWdm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mParams = new WindowManager.LayoutParams();
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mWdm.addView(textView,mParams);
    }


    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.full_screen_btn:
                   startActivity(new Intent(MainListActivity.this,MenuDailogActivity.class));
                   toast("full_screen_btn");
                   break;
              case R.id.two_btn:
                   startActivity(new Intent(MainListActivity.this,PopWindowActivity.class));
                   toast("two_btn");
                   break;
              case R.id.three_btn:
                   startActivity(new Intent(MainListActivity.this, BottomPopWindowActivity.class));
                   break;
              case R.id.four_btn:
                  startActivity(new Intent(MainListActivity.this, LeftPopWindowActivity.class));
                  break;
              case R.id.five_btn:
                  LayoutInflater inflater = getLayoutInflater();
                  View layout = inflater.inflate(R.layout.custom_toast, null);
                  TextView textView = (TextView)layout.findViewById(R.id.actionbar_height);

                  Toast toast = new Toast(getApplicationContext());

                  //toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
                  //去掉ActionBar高度
                //  int height = MainListActivity.this.getActionBar().getHeight();
                  textView.setText("获取不到");
                  toast.setGravity( Gravity.TOP, 0, 50);
                  toast.setDuration(Toast.LENGTH_LONG);

                  toast.setView(layout);
                  toast.show();
                  break;
          }
    }

    public void toast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    class ViewBuilder {
        List<View> viewList = new ArrayList<View>();
        private View rootView;
        private Activity activity;
        public ViewBuilder(View view){
            this.rootView = view;
        }

        public ViewBuilder(Activity activity){
            this.activity = activity;
        }

        public ViewBuilder $(int id){
            View view = null;
            if(activity!=null){
                view = activity.findViewById(id);
            }
            if(rootView!=null){
                view = rootView.findViewById(id);
            }
            viewList.add(view);
            return this;
        }
        public void setOnClickListener(OnClickListener listener){
            for (View view:viewList){
                view.setOnClickListener(listener);
            }
        }
    }
}
