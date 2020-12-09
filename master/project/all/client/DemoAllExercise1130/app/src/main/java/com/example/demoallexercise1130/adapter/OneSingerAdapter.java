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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.entity.Musician;


import java.util.List;

public class OneSingerAdapter extends RecyclerView.Adapter<OneSingerAdapter.NewViewHolder>{
    private Context context;
    private List<Musician> datalist;
    private View view;

    public OneSingerAdapter(Context context, List<Musician> list){
        this.context = context;
        this.datalist = list;
    }

    @NonNull
    @Override
    public OneSingerAdapter.NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.onesinger_item,parent,false);
        return new OneSingerAdapter.NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneSingerAdapter.NewViewHolder holder, int position) {
        Bitmap header = BitmapFactory.decodeFile(context.getFilesDir().getAbsolutePath()+"/imgs/"+datalist.get(position).getPhotoId());
        Log.e("lalall",context.getFilesDir().getAbsolutePath()+"/imgs/"+datalist.get(position).getPhotoId());
        Glide.with(context).load(header).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.ivImg);
        //holder.ivImg.setImageBitmap(header);
        Log.e("ppppppppppppp","进去了");
        holder.tvName.setText(datalist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public static class NewViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvName;

        public NewViewHolder(View view){
            super(view);
            ivImg = view.findViewById(R.id.iv_hsongImg);
            tvName = view.findViewById(R.id.tv_hsingerName);

        }
    }
}
