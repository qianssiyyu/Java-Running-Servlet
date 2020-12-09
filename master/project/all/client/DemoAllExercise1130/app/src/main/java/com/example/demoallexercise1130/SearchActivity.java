package com.example.demoallexercise1130;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.demoallexercise1130.adapter.MyAdapter;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.rvHots)
    RecyclerView recyclerView1;
    @BindView(R.id.rvHistory)
    RecyclerView recyclerView2;
    List<String> list = new ArrayList<>();
    @BindView(R.id.atv_content)
    AutoCompleteTextView autoCompleteTextView;
    private static final String[] data = new String[]{
            "易烊千玺","三号线","yiyangqianxi","易烊万千"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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
        list.add("粉雾海");
        list.add("yiyangqianxi");
        list.add("后座剧场");
        list.add("从此我们一别两宽");
    }
}