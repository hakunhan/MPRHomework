package com.example.tut04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(link);
        videoView.setMediaController(new MediaController(this));

        videoView.start();

    }
}