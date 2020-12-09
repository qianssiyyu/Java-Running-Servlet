package com.example.demoallexercise1130.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.entity.Song;

import java.util.List;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.MyViewHolder> {
    private Context context;
    private List<Song> datalist;
    private View view;

    public HotSongAdapter(Context context, List<Song> list){
        this.context = context;
        this.datalist = list;
    }

    @NonNull
    @Override
    public HotSongAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.hotsong_item,parent,false);
        return new HotSongAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotSongAdapter.MyViewHolder holder, int position) {
        Bitmap header = BitmapFactory.decodeFile(context.getFilesDir().getAbsolutePath()+"/imgs/"+datalist.get(position).getImgpath());
        Log.e("path",context.getFilesDir().getAbsolutePath()+"/imgs/"+datalist.get(position).getImgpath());
        Glide.with(context).load(header).transform().into(holder.ivImg);
        //holder.ivImg.setImageBitmap(header);
        Log.e("kkkkkkkkk","ji进去了");
        holder.tvName.setText(datalist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvName;

        public MyViewHolder(View view){
            super(view);
            ivImg = view.findViewById(R.id.iv_hsongImg);
            tvName = view.findViewById(R.id.tv_hsongName);

        }
    }
}
