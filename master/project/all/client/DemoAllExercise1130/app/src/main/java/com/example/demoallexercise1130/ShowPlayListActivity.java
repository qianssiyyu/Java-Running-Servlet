package com.example.demoallexercise1130;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.demoallexercise1130.adapter.ListPlayAdapter;
import com.example.demoallexercise1130.entity.SongModel;

import java.util.ArrayList;
import java.util.List;

public class ShowPlayListActivity extends AppCompatActivity {
    private List<SongModel> list = new ArrayList<SongModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_play_list);
        //初始化假数据
        initData();
        ListPlayAdapter adapter = new ListPlayAdapter(this,list,R.layout.songs_item_text);
        ListView listView = findViewById(R.id.lv_songs);
        listView.setAdapter(adapter);
    }

    private void initData() {
        SongModel songModel = new SongModel();
        songModel.setName("name1");
        songModel.setAuthor("author1");
        SongModel songModel1 = new SongModel();
        songModel1.setName("name1");
        songModel1.setAuthor("author1");
        list.add(songModel);
        list.add(songModel1);
    }
}