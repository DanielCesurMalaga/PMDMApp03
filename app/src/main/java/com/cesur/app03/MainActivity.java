package com.cesur.app03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private Button botonMusica;
    private Button botonVideo;
    private SharedPreferences misPreferencias;
    private Switch modoOscuro;
    private ConstraintLayout main;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        misPreferencias = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();


        botonMusica = (Button) findViewById(R.id.botonMusica);
        botonVideo = (Button) findViewById(R.id.botonVideo);
        modoOscuro = (Switch) findViewById(R.id.modoOscuro);
        main = (ConstraintLayout) findViewById(R.id.main);
        titulo = (TextView) findViewById(R.id.titulo);

        if (misPreferencias.getBoolean("modoOscuro", false)) {
            main.setBackgroundColor(Color.DKGRAY);
            titulo.setTextColor(Color.WHITE);
            modoOscuro.setTextColor(Color.WHITE);
            modoOscuro.setChecked(true);
        } else {
            main.setBackgroundColor(Color.WHITE);
            titulo.setTextColor(Color.BLACK);
            modoOscuro.setTextColor(Color.BLACK);
            modoOscuro.setChecked(false);
        }

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

        modoOscuro.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (modoOscuro.isChecked()) {
                            main.setBackgroundColor(Color.DKGRAY);
                            titulo.setTextColor(Color.WHITE);
                            modoOscuro.setTextColor(Color.WHITE);
                        } else {
                            main.setBackgroundColor(Color.WHITE);
                            titulo.setTextColor(Color.BLACK);
                            modoOscuro.setTextColor(Color.BLACK);
                        }
                        editor.putBoolean("modoOscuro", modoOscuro.isChecked());
                        editor.apply();
                    }
                }
        );


    }


}