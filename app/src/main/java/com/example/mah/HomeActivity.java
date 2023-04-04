package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity {

    TextView tv;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = findViewById(R.id.chatbot);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                startActivity(new Intent(HomeActivity.this,ChatBotActivity.class));
            }
        });


        SharedPreferences sp = getSharedPreferences("shared_prefs",MODE_PRIVATE);
        String username=sp.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome: "+username.toUpperCase(), Toast.LENGTH_SHORT).show();


        CardView article = findViewById(R.id.cardArticle);
        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ArticleActivity.class));
            }
        });


        CardView musc = findViewById(R.id.cardMusic);
        musc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Finalmusic.class));
            }
        });

        CardView vdo = findViewById(R.id.cardVideo);
        vdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,VideoActivity.class));
            }
        });

        CardView journals= findViewById(R.id.cardJournals);
        journals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,JournalsActivity.class));
            }
        });

        CardView session= findViewById(R.id.cardSession);
        session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SessionActivity.class));
            }
        });

        CardView dddetail= findViewById(R.id.carddetail);
        dddetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));
            }
        });
        getSupportActionBar().hide();

        videoView=findViewById(R.id.videoview);
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.clip1);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    @Override
    protected void onResume() {
        videoView.resume();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }
}
