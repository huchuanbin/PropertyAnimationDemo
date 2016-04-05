package com.example.huchuanbin.propertyanimationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnObject)
    public void btnObject() {
        intent = new Intent(this, ObjectAnimationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnValue)
    public void btnValue() {
        intent = new Intent(this, ValueAnimationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnSet)
    public void btnSet() {
        intent = new Intent(this, AnimatorSetActivity.class);
        startActivity(intent);
    }

}
