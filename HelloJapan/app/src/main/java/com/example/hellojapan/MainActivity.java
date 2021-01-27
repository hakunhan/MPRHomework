package com.example.hellojapan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private boolean buttonOne = true, buttonTwo = false;
    private Button hiraganaButton, katakanaButton;
    private ScrollView hiraganaScrollView, katakanaScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hiraganaButton = (Button) findViewById(R.id.hiraganaButton);
        katakanaButton = (Button) findViewById(R.id.katakanaButton);

        hiraganaScrollView = (ScrollView) findViewById(R.id.hiragana_scrollView);
        katakanaScrollView = (ScrollView) findViewById(R.id.katakana_scrollView);

        hiraganaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonTwo) {
                    hiraganaScrollView.setVisibility(View.VISIBLE);
                    katakanaScrollView.setVisibility(View.GONE);

                    hiraganaButton.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                    katakanaButton.setBackgroundColor(Color.parseColor("#FFFFFFFF"));

                    buttonOne = true;
                    buttonTwo = false;
                }
            }
        });

        katakanaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOne){
                    katakanaScrollView.setVisibility(View.VISIBLE);
                    hiraganaScrollView.setVisibility(View.GONE);

                    katakanaButton.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                    hiraganaButton.setBackgroundColor(Color.parseColor("#FFFFFFFF"));

                    buttonOne = false;
                    buttonTwo = true;
                }
            }
        });
    }
}