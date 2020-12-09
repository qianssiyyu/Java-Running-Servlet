package com.example.demoallexercise1130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.rapstar.Titanic;
import com.example.rapstar.TitanicTextView;
import com.example.rapstar.Typefaces;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tvSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);

        // set fancy typeface
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        new Titanic().start(tv);

        //获取视图控件
        tvSlogan = findViewById(R.id.tv_slogan);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //添加tvSlogan文字
                tvSlogan.setText("rrrap！");
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        },2500);
    }
}