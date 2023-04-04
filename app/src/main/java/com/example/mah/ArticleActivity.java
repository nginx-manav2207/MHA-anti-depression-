package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    ImageButton btn;
    Switch sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        btn = findViewById(R.id.imageButtonBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArticleActivity.this, HomeActivity.class));
            }
        });

        sb = findViewById(R.id.switchtoJournals);
        sb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle Switch button state change
                if (isChecked) {
                    startActivity(new Intent(ArticleActivity.this, JournalsActivity.class));
                } else {
                    // Do nothing or show a message to the user
                    Toast.makeText(ArticleActivity.this, "Switch is off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Listitem> items = new ArrayList<Listitem>();
        items.add(new Listitem(" 10 Natural Ways to Beat Depression\" by Harvard Health Publishing: ", "This article offers practical tips for managing depression, including getting regular exercise, eating a healthy diet, and practicing mindfulness meditation.",R.drawable.ar1));
        items.add(new Listitem("Cognitive Behavioral Therapy for Depression\" by the American Psychological Association:", "This article explains how cognitive-behavioral therapy (CBT) can be an effective treatment for depression. It describes how CBT works and what to expect from a typical session.",R.drawable.ar1));
        items.add(new Listitem("How to Help Someone with Depression: 9 Ways to Be Supportive\" by Healthline:", "This article offers advice for friends and family members of people with depression, including how to listen actively, avoid judgment, and encourage professional help when needed.",R.drawable.ar1));
        items.add(new Listitem("The Power of Exercise for Depression\" by the National Institute of Mental Health: ", " This article highlights the benefits of exercise for improving mood and reducing symptoms of depression. It discusses how exercise affects the brain and provides tips for incorporating physical activity into a daily routine.", R.drawable.ar1));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));


    }
}
