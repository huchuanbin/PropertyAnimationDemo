package com.example.huchuanbin.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XmlActivity extends AppCompatActivity {
@Bind(R.id.ivDemo)
    ImageView ivDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.scaleX)
    public void scaleX(){
        Animator animator= AnimatorInflater.loadAnimator(this,R.animator.scalex);
        animator.setTarget(ivDemo);
        animator.start();
    }
    @OnClick(R.id.together)
    public void together(){
Animator animator=AnimatorInflater.loadAnimator(this, R.animator.together);
        ivDemo.setPivotX(0);
        ivDemo.setPivotY(0);
        //显示的调用invalidate
        ivDemo.invalidate();
        animator.setTarget(ivDemo);
        animator.start();
    }
}
