package com.example.demoallexercise1130.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoallexercise1130.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> datalist;


    public SongAdapter(Context context, List<String> list){
        this.context = context;
        this.datalist = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_data,parent,false);
        return new SongAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyAdapter.MyViewHolder){
            ((MyAdapter.MyViewHolder) holder).bind(position);
        }

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.keyword)
        TextView tvHistory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void bind(int position) {
            tvHistory.setText(datalist.get(position));
        }

    }
}

