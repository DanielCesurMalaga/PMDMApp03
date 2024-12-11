package com.cesur.app03;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private Button boton2;
    private Button iniciarMp3;
    private Button pausarMp3;
    private Button pararMp3;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        boton2 = findViewById(R.id.musicaAppal);
        iniciarMp3 = findViewById(R.id.iniciarMp3);
        pausarMp3 = findViewById(R.id.pausarMp3);
        pararMp3 = findViewById(R.id.pararMp3);

        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.starwars);

        iniciarMp3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mp.start();
                    }
                }
        );

        pausarMp3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.pause();
                    }
                }
        );

        pararMp3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.stop();
                    }
                }
        );

        boton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Activity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}