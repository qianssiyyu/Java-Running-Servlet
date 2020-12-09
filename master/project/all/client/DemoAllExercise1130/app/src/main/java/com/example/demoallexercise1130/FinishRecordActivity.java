package com.example.demoallexercise1130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishRecordActivity extends AppCompatActivity {
    private Button btnRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_record);

        //获取视图控件
        findViews();
        //设置监听
        setListeners();
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_finish_release:
                    //跳转到发布页
                    Intent intent = new Intent();
                    intent.setClass(FinishRecordActivity.this,ReleaseRecordActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    private void setListeners() {
        MyListener myListener = new MyListener();
        btnRelease.setOnClickListener(myListener);
    }

    private void findViews() {
        btnRelease = findViewById(R.id.btn_finish_release);
    }
}
