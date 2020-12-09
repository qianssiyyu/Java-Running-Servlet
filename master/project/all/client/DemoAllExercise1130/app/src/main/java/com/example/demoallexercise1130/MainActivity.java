package com.example.demoallexercise1130;

import androidx.annotation.RequiresApi;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.demoallexercise1130.adapter.MyFragmentPagerAdapter;
import com.example.demoallexercise1130.fragment.FirstFragment;
import com.example.demoallexercise1130.fragment.FourFragment;
import com.example.demoallexercise1130.fragment.SecondFragment;
import com.example.demoallexercise1130.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class MainActivity extends PlayMusicActivity {
    private static MediaPlayer mediaPlayer= new MediaPlayer();
    @BindView(R.id.dl_all)
    DrawerLayout drawerLayout;
    @OnClick(R.id.btn_mymean)
    public void openDraw(){
        drawerLayout.openDrawer(Gravity.LEFT);
    }
    @OnClick(R.id.btn_search)
    public void moveSearch(){
        Intent i = new Intent();
        i.setClass(MainActivity.this,SearchActivity.class);
        startActivity(i);

    }
    @BindView(R.id.vp_show)
    ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    @BindViews({R.id.tv_item_one,R.id.tv_item_two,R.id.tv_item_three,R.id.tv_item_four})
    List<TextView> textViewList;
    @OnPageChange(R.id.vp_show)
    public void onPageSelected(int position){
        switch (position) {
            case 0:
                textViewList.get(0).setTextSize(25);
                textViewList.get(1).setTextSize(14);
                textViewList.get(2).setTextSize(14);
                textViewList.get(3).setTextSize(14);
                break;
            case 1:
                textViewList.get(1).setTextSize(25);
                textViewList.get(0).setTextSize(14);
                textViewList.get(2).setTextSize(14);
                textViewList.get(3).setTextSize(16);
                break;
            case 2:
                textViewList.get(2).setTextSize(25);
                textViewList.get(1).setTextSize(16);
                textViewList.get(0).setTextSize(16);
                textViewList.get(3).setTextSize(16);
                break;
            case 3:
                textViewList.get(3).setTextSize(25);
                textViewList.get(1).setTextSize(16);
                textViewList.get(2).setTextSize(16);
                textViewList.get(0).setTextSize(16);
                break;
        }
    }
    @OnClick({R.id.tv_item_one,R.id.tv_item_two,R.id.tv_item_three,R.id.tv_item_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_item_one:
                viewPager.setCurrentItem(0);
                textViewList.get(0).setTextSize(25);
                textViewList.get(1).setTextSize(14);
                textViewList.get(2).setTextSize(14);
                textViewList.get(3).setTextSize(14);

                break;
            case R.id.tv_item_two:
                viewPager.setCurrentItem(1);
                textViewList.get(1).setTextSize(25);
                textViewList.get(0).setTextSize(14);
                textViewList.get(2).setTextSize(14);
                textViewList.get(3).setTextSize(16);

                break;
            case R.id.tv_item_three:
                viewPager.setCurrentItem(2);
                textViewList.get(2).setTextSize(25);
                textViewList.get(1).setTextSize(16);
                textViewList.get(0).setTextSize(16);
                textViewList.get(3).setTextSize(16);

                break;
            case R.id.tv_item_four:
                viewPager.setCurrentItem(3);
                textViewList.get(3).setTextSize(25);
                textViewList.get(1).setTextSize(16);
                textViewList.get(2).setTextSize(16);
                textViewList.get(0).setTextSize(16);

                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.bind(this);
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThirdFragment());
        list.add(new FourFragment());
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(1);
        textViewList.get(1).setTextSize(25);
    }
}