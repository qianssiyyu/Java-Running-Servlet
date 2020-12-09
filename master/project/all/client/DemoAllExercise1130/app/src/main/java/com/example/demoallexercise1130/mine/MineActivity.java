package com.example.demoallexercise1130.mine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.mine.fragment.GridViewFragment;
import com.example.demoallexercise1130.mine.fragment.ListViewFragment;
import com.example.demoallexercise1130.mine.fragment.RecyclerViewFragment;
import com.example.demoallexercise1130.mine.fragment.ScrollViewFragment;
import com.example.demoallexercise1130.mine.fragment.WebViewFragment;
import com.example.demoallexercise1130.mine.fragment.base.HeaderViewPagerFragment;
import com.lzy.widget.HeaderViewPager;
import com.lzy.widget.tab.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class MineActivity extends AppCompatActivity {

    public List<HeaderViewPagerFragment> fragments;
    private HeaderViewPager scrollableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        //内容的fragment
        fragments = new ArrayList<>();
        fragments.add(ScrollViewFragment.newInstance());
        fragments.add(ListViewFragment.newInstance());
        fragments.add(GridViewFragment.newInstance());
        fragments.add(RecyclerViewFragment.newInstance());
        fragments.add(WebViewFragment.newInstance());

        scrollableLayout = (HeaderViewPager) findViewById(R.id.scrollableLayout);

        //tab标签和内容viewpager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ContentAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);
        scrollableLayout.setCurrentScrollableContainer(fragments.get(0));
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                scrollableLayout.setCurrentScrollableContainer(fragments.get(position));
            }
        });

        viewPager.setCurrentItem(0);
    }


    /**
     * 内容页的适配器
     */
    private class ContentAdapter extends FragmentPagerAdapter {

        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        public String[] titles = new String[]{"伴奏单", "歌单", "GridView消息", "RecyclerView动态", "WebView"};

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
