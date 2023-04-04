package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView clip = findViewById(R.id.clip);
        clip.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.clip);
        MediaController mediaController = new MediaController(this);
        clip.setMediaController(mediaController);
        mediaController.setAnchorView(clip);
        clip.start();
    }
}