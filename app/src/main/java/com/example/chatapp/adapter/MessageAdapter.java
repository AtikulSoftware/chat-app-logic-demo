package com.example.chatapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.chatapp.R;
import com.example.chatapp.model.Message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView senderNameTextView;
        TextView messageContentTextView;
        TextView timestampTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            senderNameTextView = itemView.findViewById(R.id.senderNameTextView);
            messageContentTextView = itemView.findViewById(R.id.messageContentTextView);
            timestampTextView = itemView.findViewById(R.id.timestampTextView);
        }

        public void bind(Message message) {
            senderNameTextView.setText(message.getSenderName());
            messageContentTextView.setText(message.getMessageContent());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy hh:mm a", Locale.getDefault());
            String formattedDateTime = sdf.format(new Date(message.getTimestamp()));
            timestampTextView.setText(formattedDateTime);

           // timestampTextView.setText(String.valueOf(message.getTimestamp()));
        }
    }
} // MessageAdapter end here ===========