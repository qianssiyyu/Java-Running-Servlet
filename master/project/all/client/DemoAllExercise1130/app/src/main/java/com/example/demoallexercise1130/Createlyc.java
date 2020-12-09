package com.example.demoallexercise1130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Createlyc extends AppCompatActivity {
    private EditText edlyc;
    private Button btno;
    private Button btyes;
    private String NewLyc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏title
        setContentView(R.layout.activity_createlyc);

        edlyc=findViewById(R.id.edt_lyc);
        btno=findViewById(R.id.bt_no);
        btyes=findViewById(R.id.bt_yes);



        MyListener myListener = new MyListener();
        btno.setOnClickListener(myListener);
        btyes.setOnClickListener(myListener);
    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_no:
                    Intent in1 = new Intent();
                    in1.setClass(Createlyc.this,CreateRadio.class);
                    startActivity(in1);
                    break;
                case R.id.bt_yes:
                    NewLyc = edlyc.getText().toString();
                    Intent in2 = new Intent();
                    in2.setClass(Createlyc.this,CreateRadio.class);
                    in2.putExtra("newlyc",NewLyc);
                    startActivity(in2);
                    break;
            }
        }
    }
}
