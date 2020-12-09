package com.example.demoallexercise1130.mine.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.mine.beans.User;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;    // 上下文环境
    private List<User> users=new ArrayList<>(); // 声明数据源
    private int item_layout_id; // 声明列表项的布局
    // 声明列表项中的控件
    public CustomAdapter(Context context, List<User> users,
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
        ImageView iv_user = (ImageView) convertView.findViewById(R.id.iv_user);
        TextView tv_gedanming = (TextView) convertView.findViewById(R.id.tv_gedanming);
        Button btn_more= (Button) convertView.findViewById(R.id.btn_more);
        // 给数据项填充数据

        Bitmap header = BitmapFactory.decodeFile(users.get(position).getPath());
        iv_user.setImageBitmap(header);
        tv_gedanming.setText(users.get(position).getSonglist());
        // 给列表项中的控件注册事件监听器,点击更多显示三个悬浮按钮
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示三个悬浮按钮
                showPopupWindow();
            }});
        return convertView; // 返回列表项
    }

    private void showPopupWindow() {
        //创建PopupWindow对象
        final PopupWindow popupWindow=new PopupWindow(context);
        //设置弹出窗口宽度
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        //设置视图
        View view = LayoutInflater.from(context).inflate(R.layout.mine_popupwindow, null);
                //getLayoutInflater().inflate(R.layout.popupwindow,null);
        //设置视图中控件属性和监听器
        Button btnCancel= (Button) view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setContentView(view);
        //显示popupwindow(显示指定位置)
        LinearLayout father= (LinearLayout) view.findViewById(R.id.father);
        popupWindow.showAtLocation(father, Gravity.CENTER,0,0);
    }
}
