package com.cesur.app03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    private Button videoAppal;
    private Button iniciarVideo;
    private Button pausarVideo;
    private Button tamanoVideo;
    private VideoView video;
    private MediaController mc;

    private boolean videoFull = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        videoAppal = (Button) findViewById(R.id.videoAppal);
        iniciarVideo = (Button) findViewById(R.id.iniciarVideo);
        pausarVideo = (Button) findViewById(R.id.pausarVideo);
        tamanoVideo = (Button) findViewById(R.id.tamanoVideo);
        video = (VideoView) findViewById(R.id.video);

        mc = new MediaController(this);
        video.setMediaController(mc);
        final String URL = "android.resource://" + getPackageName() + "/" + R.raw.videoejemplo;
        Uri uri = Uri.parse(URL);
        video.setVideoURI(uri);
        ViewGroup.LayoutParams layoutParams = video.getLayoutParams();


        iniciarVideo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        video.start();
                    }
                }
        );

        pausarVideo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        video.pause();
                    }
                }
        );

        tamanoVideo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (videoFull) {
                            tamanoVideo.setText("Agrandar");
                            videoFull = false;
                            layoutParams.width = 320;
                            layoutParams.height = 180;
                        } else {
                            tamanoVideo.setText("Empequeñecer");
                            videoFull = true;
                            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                            //layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                        }
                        video.setLayoutParams(layoutParams);
                    }
                }
        );

        videoAppal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Activity3.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}