package com.example.demoallexercise1130.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.entity.Song;
import com.example.demoallexercise1130.entity.SongModel;

import java.util.ArrayList;
import java.util.List;

public class OneSongAdapter extends BaseAdapter {
    private Context context;
    private List<Song> list = new ArrayList<>();
    private int itemLayoutRes;

    public OneSongAdapter(Context context, List<Song> list, int itemLayoutRes) {
        Log.i("adapter", "getView: 构造方法");
        this.context = context;
        this.list = list;
        this.itemLayoutRes = itemLayoutRes;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        SongItemHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemLayoutRes, null);
            holder = new SongItemHolder();
            holder.oneName = convertView.findViewById(R.id.onesongName);
            holder.oneSinger = convertView.findViewById(R.id.onesongSinger);
            holder.oneImg = convertView.findViewById(R.id.onesongImg);
            convertView.setTag(holder);
        }else {
            holder = (SongItemHolder) convertView.getTag();
        }


        holder.oneName.setText(list.get(position).getName());
        holder.oneSinger.setText(list.get(position).getAuthor());
        Bitmap header = BitmapFactory.decodeFile(context.getFilesDir().getAbsolutePath()+"/imgs/"+list.get(position).getImgpath());
        Glide.with(context).load(header).into(holder.oneImg);
        Log.i("adapter", "getView: 执行了getView");

        return convertView;
    }


    static class SongItemHolder {
        private TextView oneName;
        private TextView oneSinger;
        private ImageView oneImg;
    }
}

