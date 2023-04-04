package com.example.mah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Listitem> listitems;
    private Context context;

    public MyAdapter(Context applicationContext, List<Listitem> listitems, Context context){
        this.listitems=listitems;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Listitem listitem = listitems.get(position);

        holder.textViewHead.setText(listitem.getHead());
        holder.textViewDesc.setText(listitem.getDesc());
        holder.image.setImageResource(listitem.getImageurl());

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.Abrief);
            textViewDesc = (TextView) itemView.findViewById(R.id.Adetail);
            image = (ImageView) itemView.findViewById(R.id.Aimageview);
        }
    }
}
