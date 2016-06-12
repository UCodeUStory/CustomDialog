package com.example.qiyue.customdialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Dialog dialog;
    LinearLayout linearLayout;
    ImageView ivOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOpen = (ImageView) findViewById(R.id.dialog_1);
        ivOpen.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.dialog_1){
            RotateAnimation rotateAnimation = new RotateAnimation(0f,45f,ivOpen.getWidth()/2,ivOpen.getHeight()/2);

            rotateAnimation.setDuration(200);
            ivOpen.startAnimation(rotateAnimation);
            createDialog();
            return;
        }
        if (v.getId()==R.id.lly_dialog){
             ImageView ivClose = (ImageView) v.findViewById(R.id.close_dialog);
             RotateAnimation rotateAnimation = new RotateAnimation(0f,-45f,ivClose.getWidth()/2,ivClose.getHeight()/2);
             rotateAnimation.setDuration(200);
             ivClose.startAnimation(rotateAnimation);
             close();

        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void close(){
        AnimationSet set = new AnimationSet(true);
   /*     set.addAnimation(getRotateAnimation(-270, 0, durationMillis));
        set.addAnimation(getAlphaAnimation(0.5f, 1.0f, durationMillis));*/
        set.addAnimation(UgcAnimations.getTranslateAnimation(
                0, 0f,0, 5000f, 0));
        set.setFillAfter(true);
        set.setDuration(400);
        //设置启动时间
        // set.setStartOffset((i * 100)
        //   / (-1 + relativeLayout.getChildCount()));
      //  set.setInterpolator(new OvershootInterpolator(2f));
        set.setInterpolator(new AnticipateInterpolator(1f));
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dialog.dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        linearLayout.startAnimation(set);

    }
    /**
     * 简单创建一个Dialog
     */

    private void createDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_content_1,null);
         linearLayout = (LinearLayout)view.findViewById(R.id.lly_button);
        Button left = (Button)view.findViewById(R.id.left);
        Button right = (Button)view.findViewById(R.id.right);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        view.setOnClickListener(this);
        dialog = new Dialog(this, R.style.Transparent);
        //dialog.setTitle("哈哈");
        //ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setContentView(view);
        dialog.show();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_1);
       // left.startAnimation(animation);

     //   linearLayout.startAnimation(animation);
        AnimationSet set = new AnimationSet(true);
   /*     set.addAnimation(getRotateAnimation(-270, 0, durationMillis));
        set.addAnimation(getAlphaAnimation(0.5f, 1.0f, durationMillis));*/
        set.addAnimation(UgcAnimations.getTranslateAnimation(
                -0, 0f,-5000, 0f, 0));
        set.setFillAfter(true);
        set.setDuration(400);
        //设置启动时间
       // set.setStartOffset((i * 100)
             //   / (-1 + relativeLayout.getChildCount()));
        set.setInterpolator(new OvershootInterpolator(1f));
        linearLayout.startAnimation(set);

        /**
         *  <translate
         android:duration="500"
         android:fromXDelta="0"
         android:fromYDelta="-1000"
         android:toXDelta="0"
         android:toYDelta="0" />
         * 通过window对象设置布局的高度限制，排除状态栏和标题栏，好像也不用style差不多就可以，
         *
         * 如何改变dialog 进入时动画
         *
         * 里面的内容按钮一开始可以隐藏，通过view动画平移过来后显示
         *
         * 提升z轴高度，能够换来更好体验
         *
         * 通过控制电机按钮顺时针旋转45度，然后显示第二个按钮，
         *
         * 关闭时，第二个按钮逆时针旋转45度，然后显示第一个按钮，
         */
    }
}
