package com.example.demosearch1114;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvHots)
    RecyclerView recyclerView1;
    @BindView(R.id.rvHistory)
    RecyclerView recyclerView2;
    List<String> list = new ArrayList<>();
    @BindView(R.id.atv_content)
    AutoCompleteTextView autoCompleteTextView;
    private static final String[] data = new String[]{
            "易烊千玺","三号线","会不会","易烊万千"
    };
    @OnClick(R.id.btnLa)
    public void goEalse() {
        Intent i = new Intent();
        i.setClass(MainActivity.this,HelpWordActivity.class);
        startActivity(i);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        recyclerView1.setLayoutManager(new FlexboxLayoutManager(this));
        recyclerView2.setLayoutManager(new FlexboxLayoutManager(this));
        recyclerView1.setAdapter(new MyAdapter(this,list));
        recyclerView2.setAdapter(new MyAdapter(this,list));
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,data));


    }

    public void initData(){
        list.add("易烊千玺");
        list.add("三号线");
        list.add("会不会");
        list.add("从此我们一别两宽");
    }
}