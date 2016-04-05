package com.example.huchuanbin.propertyanimationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends AppCompatActivity {
    @Bind(R.id.ball)
    ImageView ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.togetherRun)
    public void togetherRun(){
        ObjectAnimator animator1=new ObjectAnimator().ofFloat(ball,"scaleX",1.0F,2.0F);
        ObjectAnimator animator2=new ObjectAnimator().ofFloat(ball,"scaleY",1.0F,2.0F);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(animator1,animator2);
        animatorSet.start();
    }
    @OnClick(R.id.playWithAfter)
    public void playWithAfter(){
        float cx = ball.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(ball, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(ball, "scaleY",
                1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(ball,
                "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(ball,
                "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }
}
