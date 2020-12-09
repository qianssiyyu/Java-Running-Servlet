package com.example.demoallexercise1130.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.entity.SongModel;

import java.util.ArrayList;
import java.util.List;

public class ListPlayAdapter extends BaseAdapter {
    private Context context;
    private List<SongModel> list = new ArrayList<>();
    private int itemLayoutRes;

    public ListPlayAdapter(Context context, List<SongModel> list, int itemLayoutRes) {
        Log.i("adapter", "getView: 构造方法");
        this.context = context;
        this.list = list;
        this.itemLayoutRes = itemLayoutRes;
    }

    @Override
    public int getCount() {
        Log.i("adapter", "getCount: ");
        if (null != list) {
            Log.i("adapter", "getCount: "+list.size());
            return list.size();

        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        Log.i("adapter", "getItem: ");
        if (null != list) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        Log.i("adapter", "getItemId: ");
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i("adapter", "getView: 执行了getView");
        MusicItemHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemLayoutRes, null);
            holder = new MusicItemHolder();
            holder.authorName = convertView.findViewById(R.id.tv_author);
            holder.musicName = convertView.findViewById(R.id.tv_song);
            holder.linearLayout = convertView.findViewById(R.id.ll_song_item);
            convertView.setTag(holder);
        }else {
            holder = (MusicItemHolder) convertView.getTag();
        }


        holder.musicName.setText(list.get(position).getName());
        holder.authorName.setText(""+list.get(position).getAuthor());
        holder.linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("lxl","点击了rl");
                //TODO 点击之后进行播放
//                Bitmap bitmap = list.get(position).getImg();
//                byte buf[] = ConfigUtil.Bitmap2Bytes(bitmap);
            }
        });
        return convertView;
    }


    static class MusicItemHolder {
        private TextView musicName;
        private TextView authorName;
        private LinearLayout linearLayout;
    }
}
