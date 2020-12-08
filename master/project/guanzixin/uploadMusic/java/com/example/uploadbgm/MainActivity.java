package com.example.uploadbgm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        findViews();
        //设置监听方法
        setListeners();
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_upload:
                    Toast.makeText(getApplicationContext(),"选择封面",Toast.LENGTH_SHORT).show();
                    Resources resources = getBaseContext().getResources();
                    Drawable imageDrawable = resources.getDrawable(R.drawable.cover_demo);
                    btnUpload.setBackground(imageDrawable);
                    break;
            }
        }
    }

    private void setListeners() {
        MyListener myListener = new MyListener();
        btnUpload.setOnClickListener(myListener);
    }

    private void findViews() {
        btnUpload = findViewById(R.id.btn_upload);
    }
}