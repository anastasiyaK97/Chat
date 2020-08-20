package com.example.chatme.Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatme.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class MessageController extends RecyclerView.Adapter {
    private static final int TYPE_OUT = 1;
    private static final int TYPE_IN = 0;

    private List<Message> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView messageTime;
        TextView userName;

        public MyViewHolder(View view) {
            super(view);
            messageText = view.findViewById(R.id.messageTextView);
            messageTime = view.findViewById(R.id.TimeTextView);
            userName = view.findViewById(R.id.userTextView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_OUT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.outgoing_message, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.outgoing_message, parent, false);
        }

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Message currentMessage = list.get(position);
        ((MyViewHolder)holder).messageText.setText(currentMessage.getText());
        DateFormat dateFmt = SimpleDateFormat.getTimeInstance(DateFormat.SHORT);
        ((MyViewHolder)holder).messageTime.setText(dateFmt.format(currentMessage.getDate()));
        ((MyViewHolder)holder).userName.setText(currentMessage.getUserFrom().getLogin());
    }

    @Override
    public int getItemCount() {
            return list.size();
    }

    public MessageController(List<Message> list) {
        this.list = list;
    }

}
