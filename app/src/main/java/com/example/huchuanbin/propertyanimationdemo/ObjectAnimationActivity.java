package com.example.huchuanbin.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimationActivity extends AppCompatActivity {
    private ObjectAnimator animator;
    @Bind(R.id.iv)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.translation)
    public void translation() {
        ObjectAnimator.ofFloat(imageView, "translationX", 0.0F, 350.0F, 10.0F)
                .setDuration(2500)
                .start();
    }

    @OnClick(R.id.scale)
    public void scale() {
        ObjectAnimator.ofFloat(imageView, "scaleX", 1.0F, 1.5F, 1.0F)
                .setDuration(2500)
                .start();
    }

    @OnClick(R.id.rotation)
    public void rotation() {
        ObjectAnimator.ofFloat(imageView, "rotationX", 0.0F, 360.0F)
                .setDuration(2500)
                .start();
    }

    @OnClick(R.id.alpha)
    public void alpha() {
        ObjectAnimator.ofFloat(imageView, "alpha", 1.0F, 0.3F, 1.0F)
                .setDuration(2500)
                .start();
    }

    @OnClick(R.id.text1)
    public void text1() {
        animator = ObjectAnimator.ofFloat(imageView, "alpha", 1.0F, 0.3F, 1.0F);
        animator.setDuration(2000);//动画时间
        animator.setInterpolator(new BounceInterpolator());//动画插值
        animator.setRepeatCount(2);//设置动画重复次数
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.setStartDelay(1000);//动画延时执行
        animator.start();//启动动画
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(ObjectAnimationActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.text2)
    public void text2() {
        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("translationX", 0.0F, 300.0F);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 1F, 1.5F);
        PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("rotationX", 0.0F, 90F, 0.0F);
        PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofFloat("alpha", 1.0F, 0.3F, 1.0F);
        ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder1, propertyValuesHolder2, propertyValuesHolder3, propertyValuesHolder4).setDuration(1000).start();
    }

}
