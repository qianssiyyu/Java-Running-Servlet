package com.example.demoallexercise1130.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.demoallexercise1130.RecordVoiceActivity;
import com.example.demoallexercise1130.adapter.AccAdapter;
import com.example.demoallexercise1130.MyGallyPageTransformer;
import com.example.demoallexercise1130.adapter.MyViewPageAdapter;
import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.entity.Accompany;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.lzy.widget.HeaderViewPager;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {
    //private Unbinder unbinder;
    private ViewPager vp;
    private List<Integer> images=new ArrayList<>();
    private HeaderViewPager scrollableLayout;
    private ViewPager pagerHeader;
    private View titleBar_Bg;
    private TextView titleBar_title;
    private View status_bar_fix;
    private View titleBar;
    private List<Accompany> acclist = new ArrayList<>();
    private View view;
    private FloatingActionButton button2Record;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.thirdfragment, null);
        //unbinder = ButterKnife.bind(this,view);
        AccAdapter customAdapter = new AccAdapter(getContext(),acclist,R.layout.acc_item);
        ListView ListView = view.findViewById(R.id.acc_list);
        ListView.setAdapter(customAdapter);

        //viewpage相关
        viewpage();

        InitData();

        return view;
    }

    //@Override
    /*public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }*/

    private void viewpage() {
        vp = view.findViewById(R.id.vp);
        images.add(R.mipmap.img3);
        images.add(R.mipmap.img4);
        images.add(R.mipmap.img5);
        vp.setOffscreenPageLimit(3);
        int pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 4.0f / 5.0f);
        ViewGroup.LayoutParams lp = vp.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        vp.setLayoutParams(lp);
//setPageMargin表示设置图片之间的间距
        vp.setPageMargin(1);
//setPageMargin表示设置图片之间的间距
        vp.setPageTransformer(true, new MyGallyPageTransformer());
        vp.setAdapter(new MyViewPageAdapter(images, getContext()));
        vp.setCurrentItem(2000);
//        pagerHeader = (ViewPager) findViewById(R.id.pagerHeader);
//        pagerHeader.setAdapter(new HeaderAdapter());
//        CircleIndicator ci = (CircleIndicator) findViewById(R.id.ci);
//        ci.setViewPager(pagerHeader);

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        //当前窗口获取焦点时，才能正真拿到titlebar的高度，此时将需要固定的偏移量设置给scrollableLayout即可
//        scrollableLayout.setTopOffset(titleBar.getHeight());
//    }

    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.action_a:
                    Intent intent = new Intent(getActivity(), RecordVoiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.action_b:
                    //TODO:
                    break;
            }
        }
    }

    private void InitData() {
        button2Record = view.findViewById(R.id.action_a);
        Accompany s1 = new Accompany(1, "MONST3ER-Demo","s" , 1, "1", "ATEEZ-", 1216);

        acclist.add(s1);acclist.add(s1);
        acclist.add(s1);acclist.add(s1);acclist.add(s1);
    }




}
