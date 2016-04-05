package com.example.huchuanbin.propertyanimationdemo;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimationActivity extends AppCompatActivity {

    @Bind(R.id.ball)
    ImageView ball;
    @Bind(R.id.freeBall)
    ImageView freeBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ball)
    public void ball() {
        Toast.makeText(this, "你好,我是小球", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.verticalRun)
    public void vertriaclRun() {
        ValueAnimator valueAnimator = new ValueAnimator().ofFloat(0, 1000 - ball.getHeight());
        valueAnimator.setTarget(ball);
        valueAnimator.setDuration(3000).start();
        valueAnimator.addUpdateListener(animator -> ball.setTranslationY((Float) animator.getAnimatedValue()));
    }

    @OnClick(R.id.parabolaRun)
    public void parabolaRun() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator((v, start, end) -> {
            PointF point = new PointF();
            point.x = 200 * v * 3;
            point.y = 0.5f * 100 * (v * 3) * (v * 3);
            return point;
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(animator -> {
            PointF point = (PointF) animator.getAnimatedValue();
            ball.setX(point.x);
            ball.setY(point.y);
        });
    }

    @OnClick(R.id.freeRun)
    public void freeRun() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator((v, start, end) -> {
            PointF point = new PointF();
            point.x = 200 * v * 3;
            point.y = 0.5f * 100 * (v * 3) * (v * 3);
            return point;
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(animator -> {
            PointF point = (PointF) animator.getAnimatedValue();
            ball.setX(point.x);
            ball.setY(point.y);
            freeBall.setY(point.y);
        });

    }

}