package com.example.demoallexercise1130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class CreateRadio extends AppCompatActivity {
    private TextView MyLyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏title
        setContentView(R.layout.activity_create_radio);

        Intent intent = getIntent();
        String getText1 = intent.getStringExtra("newlyc");

        MyLyc=findViewById(R.id.mylyc);

        MyLyc.setText("Activity1传过来的值："+getText1);



    }
}
