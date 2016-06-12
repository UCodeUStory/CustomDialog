package com.example.qiyue.customdialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        ViewBuilder viewBuilder = new ViewBuilder(this);
        viewBuilder.$(R.id.full_screen_btn)
                .$(R.id.two_btn)
                .setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.full_screen_btn:
                   startActivity(new Intent(MainListActivity.this,MainActivity.class));
                   toast("full_screen_btn");
                   break;
              case R.id.two_btn:
                   toast("two_btn");
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
