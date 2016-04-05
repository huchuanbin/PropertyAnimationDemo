package com.example.huchuanbin.propertyanimationdemo;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutActivity extends AppCompatActivity implements OnCheckedChangeListener {
    private GridLayout gridLayout;
    private int val;
    private LayoutTransition layoutTransition;

    @Bind(R.id.id_container)
    ViewGroup viewGroup;
    @Bind(R.id.appear)
    CheckBox appear;
    @Bind(R.id.changeAppear)
    CheckBox changeAppear;
    @Bind(R.id.disappear)
    CheckBox disapper;
    @Bind(R.id.changeDisappear)
    CheckBox changeDisappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
        appear.setOnCheckedChangeListener(this);
        changeAppear.setOnCheckedChangeListener(this);
        disapper.setOnCheckedChangeListener(this);
        changeDisappear.setOnCheckedChangeListener(this);
        gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(5);
        viewGroup.addView(gridLayout);
        layoutTransition = new LayoutTransition();
        gridLayout.setLayoutTransition(layoutTransition);
    }

    @OnClick(R.id.btnAdd)
    public void btnAdd() {
        final Button button = new Button(this);
        button.setText((++val) + "");
        gridLayout.addView(button, Math.min(1, gridLayout.getChildCount()));
        button.setOnClickListener(v -> gridLayout.removeView(button));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(
                LayoutTransition.APPEARING,
                (appear.isChecked() ? layoutTransition
                        .getAnimator(LayoutTransition.APPEARING) : null));
        layoutTransition
                .setAnimator(
                        LayoutTransition.CHANGE_APPEARING,
                        (changeAppear.isChecked() ? layoutTransition
                                .getAnimator(LayoutTransition.CHANGE_APPEARING)
                                : null));
        layoutTransition.setAnimator(
                LayoutTransition.DISAPPEARING,
                (appear.isChecked() ? layoutTransition
                        .getAnimator(LayoutTransition.DISAPPEARING) : null));
        layoutTransition.setAnimator(
                LayoutTransition.CHANGE_DISAPPEARING,
                (changeDisappear.isChecked() ? layoutTransition
                        .getAnimator(LayoutTransition.CHANGE_DISAPPEARING)
                        : null));
        gridLayout.setLayoutTransition(layoutTransition);

    }
}
