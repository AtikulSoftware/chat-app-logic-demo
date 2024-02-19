package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.chatapp.adapter.MessageAdapter;
import com.example.chatapp.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView messageRecyclerView;
    MessageAdapter messageAdapter;
    List<Message> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        messageRecyclerView = findViewById(R.id.recyclerView);
        messageAdapter = new MessageAdapter(messageList);
        messageRecyclerView.setAdapter(messageAdapter);
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMessagesManually();

    } // onCreate method end here ================

    private void loadMessagesManually() {
        messageList.clear();

        messageList.add(new Message("Atikul", "Hello!", getTimeInMillis(10, 24)));
        messageList.add(new Message("Hasib", "Hi there!", getTimeInMillis(10, 25)));
        messageList.add(new Message("Humayon", "What's up?", getTimeInMillis(10, 20)));
        messageList.add(new Message("jubayer Hossain", "What's up?", getTimeInMillis(10, 34)));

        Collections.sort(messageList, new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                return Long.compare(m2.getTimestamp(), m1.getTimestamp());
            }
        });

        messageAdapter.notifyDataSetChanged();
    } // loadMessagesManually end here ==========

    private long getTimeInMillis(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    } // getTimeInMillis  end here ===============


} // public class end here =======================