package com.cesur.app03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button botonMusica;
    private Button botonVideo;
    private SharedPreferences misPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMusica = (Button) findViewById(R.id.botonMusica);
        botonVideo = (Button) findViewById(R.id.botonVideo);

        botonMusica.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        startActivity(intent);
                    }
                }
        );
        botonVideo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Activity3.class);
                        startActivity(intent);
                    }
                }
        );

        misPreferencias = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();


    }


}