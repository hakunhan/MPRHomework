package com.example.tut04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class Player extends AppCompatActivity {
    private VideoView videoView;
    private int currentVideoPos;
    private String playBack = "PLAYBACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(link);
        videoView.setMediaController(new MediaController(this));

        videoView.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentVideoPos = videoView.getCurrentPosition();

        Log.d("CurrentPos", videoView.getCurrentPosition() + "");
        Log.d("varCurrentPos", currentVideoPos + "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("beforeSaveInsCurrentPos", this.currentVideoPos +"");
        outState.putInt(playBack, this.currentVideoPos);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("afterSaveInsCurrentPos", savedInstanceState.getInt("PLAYBACK")+"");
        videoView.seekTo(savedInstanceState.getInt(playBack));
    }
}