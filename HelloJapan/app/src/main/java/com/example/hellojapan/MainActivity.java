package com.example.hellojapan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private boolean buttonOne = true, buttonTwo = false;
    private Button hiraganaButton, katakanaButton;
    private ScrollView hiraganaScrollView, katakanaScrollView;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hiraganaButton = findViewById(R.id.hiraganaButton);
        katakanaButton = findViewById(R.id.katakanaButton);

        hiraganaScrollView = findViewById(R.id.hiragana_scrollView);
        katakanaScrollView = findViewById(R.id.katakana_scrollView);

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

    public void onClickA(View view){
        mp = MediaPlayer.create(this, R.raw.a_akira);
        mp.start();
    }

    public void onClickI(View view){
        mp = MediaPlayer.create(this, R.raw.i_akira);
        mp.start();
    }

    public void onClickU(View view){
        mp = MediaPlayer.create(this, R.raw.u_akira);
        mp.start();
    }

    public void onClickE(View view){
        mp = MediaPlayer.create(this, R.raw.e_akira);
        mp.start();
    }

    public void onClickO(View view){
        mp = MediaPlayer.create(this, R.raw.o_akira);
        mp.start();
    }

    public void onClickKa(View view){
        mp = MediaPlayer.create(this, R.raw.ka_akira);
        mp.start();
    }

    public void onClickKi(View view){
        mp = MediaPlayer.create(this, R.raw.ki_akira);
        mp.start();
    }

    public void onClickKu(View view){
        mp = MediaPlayer.create(this, R.raw.ku_akira);
        mp.start();
    }

    public void onClickKe(View view){
        mp = MediaPlayer.create(this, R.raw.ke_akira);
        mp.start();
    }

    public void onClickKo(View view){
        mp = MediaPlayer.create(this, R.raw.ko_akira);
        mp.start();
    }

    public void onClickSa(View view){
        mp = MediaPlayer.create(this, R.raw.sa_akira);
        mp.start();
    }

    public void onClickShi(View view){
        mp = MediaPlayer.create(this, R.raw.shi_akira);
        mp.start();
    }

    public void onClickSu(View view){
        mp = MediaPlayer.create(this, R.raw.su_akira);
        mp.start();
    }

    public void onClickSe(View view){
        mp = MediaPlayer.create(this, R.raw.se_akira);
        mp.start();
    }

    public void onClickSo(View view){
        mp = MediaPlayer.create(this, R.raw.so_akira);
        mp.start();
    }

    public void onClickTa(View view){
        mp = MediaPlayer.create(this, R.raw.ta_akira);
        mp.start();
    }

    public void onClickChi(View view){
        mp = MediaPlayer.create(this, R.raw.chi_akira);
        mp.start();
    }

    public void onClickTsu(View view){
        mp = MediaPlayer.create(this, R.raw.tsu_akira);
        mp.start();
    }

    public void onClickTe(View view){
        mp = MediaPlayer.create(this, R.raw.te_akira);
        mp.start();
    }

    public void onClickTo(View view){
        mp = MediaPlayer.create(this, R.raw.ta_akira);
        mp.start();
    }

    public void onClickNa(View view){
        mp = MediaPlayer.create(this, R.raw.na_akira);
        mp.start();
    }

    public void onClickNi(View view){
        mp = MediaPlayer.create(this, R.raw.ni_akira);
        mp.start();
    }

    public void onClickNu(View view){
        mp = MediaPlayer.create(this, R.raw.nu_akira);
        mp.start();
    }

    public void onClickNe(View view){
        mp = MediaPlayer.create(this, R.raw.ne_akira);
        mp.start();
    }

    public void onClickNo(View view){
        mp = MediaPlayer.create(this, R.raw.no_akira);
        mp.start();
    }

    public void onClickHa(View view){
        mp = MediaPlayer.create(this, R.raw.ha_akira);
        mp.start();
    }

    public void onClickHi(View view){
        mp = MediaPlayer.create(this, R.raw.hi_akira);
        mp.start();
    }

    public void onClickFu(View view){
        mp = MediaPlayer.create(this, R.raw.fu_akira);
        mp.start();
    }

    public void onClickHe(View view){
        mp = MediaPlayer.create(this, R.raw.he_akira);
        mp.start();
    }

    public void onClickHo(View view){
        mp = MediaPlayer.create(this, R.raw.ho_akira);
        mp.start();
    }

    public void onClickMa(View view){
        mp = MediaPlayer.create(this, R.raw.ma_akira);
        mp.start();
    }

    public void onClickMi(View view){
        mp = MediaPlayer.create(this, R.raw.mi_akira);
        mp.start();
    }

    public void onClickMu(View view){
        mp = MediaPlayer.create(this, R.raw.mu_akira);
        mp.start();
    }

    public void onClickMe(View view){
        mp = MediaPlayer.create(this, R.raw.me_akira);
        mp.start();
    }

    public void onClickMo(View view){
        mp = MediaPlayer.create(this, R.raw.mo_akira);
        mp.start();
    }

    public void onClickYa(View view){
        mp = MediaPlayer.create(this, R.raw.ya_akira);
        mp.start();
    }

    public void onClickYu(View view){
        mp = MediaPlayer.create(this, R.raw.yu_akira);
        mp.start();
    }

    public void onClickYo(View view){
        mp = MediaPlayer.create(this, R.raw.yo_akira);
        mp.start();
    }


    public void onClickRa(View view){
        mp = MediaPlayer.create(this, R.raw.ra_akira);
        mp.start();
    }


    public void onClickRi(View view){
        mp = MediaPlayer.create(this, R.raw.ri_akira);
        mp.start();
    }


    public void onClickRu(View view){
        mp = MediaPlayer.create(this, R.raw.ru_akira);
        mp.start();
    }


    public void onClickRe(View view){
        mp = MediaPlayer.create(this, R.raw.re_akira);
        mp.start();
    }


    public void onClickRo(View view){
        mp = MediaPlayer.create(this, R.raw.ro_akira);
        mp.start();
    }


    public void onClickWa(View view){
        mp = MediaPlayer.create(this, R.raw.wa_akira);
        mp.start();
    }


    public void onClickWo(View view){
        mp = MediaPlayer.create(this, R.raw.wo_akira);
        mp.start();
    }


    public void onClickN(View view){
        mp = MediaPlayer.create(this, R.raw.n_akira);
        mp.start();

    }
}