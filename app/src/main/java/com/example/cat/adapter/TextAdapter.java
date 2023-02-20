package com.example.cat.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cat.R;
import com.example.cat.bean.CatAttrBean;

import java.util.ArrayList;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.MyViewHolder> {

    private List<CatAttrBean> list;
    private List<CatAttrBean> themes;

    public TextAdapter(List<CatAttrBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false)
        );
        return myViewHolder;
    }

    public void setTheme(List<CatAttrBean> themes) {
        this.themes = themes;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CatAttrBean catAttrBean = list.get(position);

//        List<String> stringList = new ArrayList<>();
//        for (CatAttrBean theme : themes) {
//            stringList.add(theme.getField3())
//        }

        if (themes != null && themes.get(position).getField3().equals(catAttrBean.getField3())) {
            //高亮
            holder.tvBlue.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.tvBlue.setTextColor(Color.parseColor("#6666FF"));

        }
        holder.tvBlue.setText(catAttrBean.getField3());
        holder.tvGreen1.setText(catAttrBean.getField4());
        holder.tvGreen2.setText(catAttrBean.getField5());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvBlue, tvGreen1, tvGreen2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBlue = itemView.findViewById(R.id.tv_blue);
            tvGreen1 = itemView.findViewById(R.id.tv_green1);
            tvGreen2 = itemView.findViewById(R.id.tv_green2);
        }
    }
}
