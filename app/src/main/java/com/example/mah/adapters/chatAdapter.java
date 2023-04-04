package com.example.mah.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mah.R;
import com.example.mah.models.message;
import java.util.List;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.MyViewHolder> {

    private List<message> messageList;
    private Activity activity;

    public chatAdapter(List<message> messageList, Activity activity) {
        this.messageList = messageList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_message_one, parent, false);
        return new MyViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String message = messageList.get(position).getMessage();
        boolean isReceived = messageList.get(position).getIsReceived();
        if(isReceived){
            holder.messageReceive.setVisibility(View.VISIBLE);
            holder.messageSend.setVisibility(View.GONE);
            holder.messageReceive.setText(message);
        }else {
            holder.messageSend.setVisibility(View.VISIBLE);
            holder.messageReceive.setVisibility(View.GONE);
            holder.messageSend.setText(message);
        }
    }

    @Override public int getItemCount() {
        return messageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView messageSend;
        TextView messageReceive;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageSend = itemView.findViewById(R.id.message_send);
            messageReceive = itemView.findViewById(R.id.message_receive);
        }
    }

}
