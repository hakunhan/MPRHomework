package com.example.tut04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView editLink = findViewById(R.id.editLink);
        ImageButton btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = editLink.getText().toString();

                Intent intent = new Intent(MainActivity.this, Player.class);
                intent.putExtra("link", link);
                startActivity(intent);
            }
        });
    }
}