package com.example.myfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myfriend.adapters.FriendAdapter;
import com.example.myfriend.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFriend = findViewById(R.id.rvFriend);

        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Trung Hieu", "hoanghieu2000a@gmail.com", "0963062140");
        friends.add(new Friend("Trung Hieu", "hoanghieu2000a@gmail.com", "0963062140");
        friends.add(new Friend("Trung Hieu", "hoanghieu2000a@gmail.com", "0963062140");
        friends.add(new Friend("Trung Hieu", "hoanghieu2000a@gmail.com", "0963062140");


        FriendAdapter friendAdapter = new FriendAdapter(friends);
        rvFriend.setAdapter(friendAdapter);
        rvFriend.setLayoutManager(new LinearLayoutManager(this));
    })
}