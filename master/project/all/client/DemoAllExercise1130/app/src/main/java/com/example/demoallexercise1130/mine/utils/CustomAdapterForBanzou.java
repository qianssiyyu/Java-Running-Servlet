package com.example.demoallexercise1130.mine.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.mine.beans.BanzouUser;


import java.util.ArrayList;
import java.util.List;

public class CustomAdapterForBanzou extends BaseAdapter {
    private Context context;    // 上下文环境
    private List<BanzouUser> users=new ArrayList<>(); // 声明数据源
    private int item_layout_id; // 声明列表项的布局
    // 声明列表项中的控件
    public CustomAdapterForBanzou(Context context, List<BanzouUser> users,
                         int item_layout_id) {
        this.context = context;       // 上下文环境
        this.users = users; // 数据源
        this.item_layout_id = item_layout_id; // 列表项布局文件ID
    }
    @Override
    public int getCount() {

        if(null != users){
            return users.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {

        if (null != users){
            return users.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(null == convertView){  // 加载列表项布局文件
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(item_layout_id,null);
        }
        // 接下来先获取列表项中的控件对象
        TextView tv_banzou = (TextView) convertView.findViewById(R.id.tv_banzou);
        Button btn_add= (Button) convertView.findViewById(R.id.btn_add);
        Button btn_save= (Button) convertView.findViewById(R.id.btn_save);
        Button btn_sing= (Button) convertView.findViewById(R.id.btn_sing);
        // 给数据项填充数据


        tv_banzou.setText(users.get(position).getBanzou());
        // 给列表项中的控件注册事件监听器,点击更多显示三个悬浮按钮
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }});
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }});
        btn_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }});
        return convertView; // 返回列表项
    }
}
