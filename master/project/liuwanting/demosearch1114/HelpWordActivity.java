package com.example.demosearch1114;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class HelpWordActivity extends AppCompatActivity {
    @BindView(R.id.vp_show)
    ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    @BindViews({R.id.tv_item_one,R.id.tv_item_two,R.id.tv_item_three})
    List<TextView> textViewList;
    @OnPageChange(R.id.vp_show)
    public void onPageSelected(int position){
        switch (position) {
            case 0:

                textViewList.get(0).setBackgroundColor(Color.GRAY);

                break;
            case 1:

                textViewList.get(1).setBackgroundColor(Color.GRAY);

                break;
            case 2:

                textViewList.get(2).setBackgroundColor(Color.GRAY);

                break;
        }
    }
    @OnClick({R.id.tv_item_one,R.id.tv_item_two,R.id.tv_item_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_item_one:
                viewPager.setCurrentItem(0);
                textViewList.get(0).setBackgroundColor(Color.GRAY);

                break;
            case R.id.tv_item_two:
                viewPager.setCurrentItem(1);
                textViewList.get(1).setBackgroundColor(Color.GRAY);

                break;
            case R.id.tv_item_three:
                viewPager.setCurrentItem(2);
                textViewList.get(2).setBackgroundColor(Color.GRAY);

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_word);
        ButterKnife.bind(this);
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThirdFragment());
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        textViewList.get(0).setBackgroundColor(Color.GRAY);
    }
}